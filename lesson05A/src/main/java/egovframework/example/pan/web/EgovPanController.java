package egovframework.example.pan.web;

import egovframework.example.pan.service.EgovPanService;
import egovframework.example.pan.service.PanVO;
import egovframework.example.sample.service.SampleDefaultVO;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EgovPanController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /** EgovSampleService */
    @Autowired
    private EgovPanService panService;

    /** Validator*/
    @Resource(name = "beanValidator")
    protected DefaultBeanValidator beanValidator;

    @RequestMapping(value = "/insertPan.do"
            ,method = RequestMethod.POST
            ,produces = "application/json;charset=utf8")
    @ResponseBody
    public String insertPan(PanVO vo,
                            HttpServletRequest req,
                            Model model) throws Exception {
        PanVO inVO = new PanVO();
        inVO.setCmID(req.getParameter("cmID"));
        inVO.setName(req.getParameter("name"));
        inVO.setPassword(req.getParameter("password"));
        inVO.setUseYN(req.getParameter("useYn"));
        inVO.setLevels(req.getParameter("levels"));
        inVO.setLogin(req.getParameter("login"));
        inVO.setRecommend(req.getParameter("recommend"));
        inVO.setEmail(req.getParameter("email"));

        int flag = 0;
        JSONObject obj = new JSONObject();
        String upsert = req.getParameter("upsert");
        switch (upsert) {
            case "update": flag = panService.updatePan(inVO);break;
            case "insert":
                LOGGER.debug("------------------------------------------");
                LOGGER.debug("vo : "+panService.insertPan(inVO));
                LOGGER.debug("------------------------------------------");
                flag = 1;break;
            default: break;
        }
        obj.put("flag", flag);
        return obj.toString();
    }


    @RequestMapping(value = "/selectPan.do"
            ,method = RequestMethod.GET
            ,produces = "application/json;charset=utf8")
    @ResponseBody
    public String selectPan(HttpServletRequest req,
                            Model model) throws Exception {
        PanVO inVO = new PanVO();
        inVO.setCmID(req.getParameter("cmID"));

        PanVO outVO = this.panService.selectPan(inVO);
        LOGGER.debug("------------------------------------------");
        LOGGER.debug("inVO : "+inVO);
        LOGGER.debug("outVO : "+outVO);
        LOGGER.debug("------------------------------------------");

        JSONObject obj = new JSONObject();
        obj.put("cmID", outVO.getCmID());
        obj.put("name", outVO.getName());
        obj.put("password", outVO.getPassword());
        obj.put("useYn", outVO.getUseYN());
        obj.put("levels", outVO.getLevels());
        obj.put("login", outVO.getLogin());
        obj.put("recommend", outVO.getRecommend());
        obj.put("email", outVO.getEmail());
        obj.put("regDt", outVO.getRegDate());

        String json = obj.toJSONString();
        LOGGER.debug("------------------------------------------");
        LOGGER.debug("json : "+json);
        LOGGER.debug("------------------------------------------");
        return json;
    }

    @RequestMapping(value = "/selectPanList.do"
            ,method = RequestMethod.GET
            ,produces = "application/json;charset=utf8")
    @ResponseBody
    public String selectPanList(HttpServletRequest req,
                                Model model) throws Exception {
        SampleDefaultVO searchVO = new SampleDefaultVO();
        String pageNumStr = req.getParameter("page_num");
        String pageSizeStr = req.getParameter("page_size");
        if (null == pageNumStr || "".equals(pageNumStr)) pageNumStr = "1";
        if (null == pageSizeStr || "".equals(pageSizeStr)) pageSizeStr = "10";
        searchVO.setPageSize(Integer.parseInt(pageNumStr));
        searchVO.setPageIndex(Integer.parseInt(pageSizeStr));

        String searchWord = req.getParameter("search_word");
        if (!(null == pageSizeStr || "".equals(pageSizeStr))) {
            searchVO.setSearchCondition("0");
            searchVO.setSearchKeyword(searchWord);
        }

        List<PanVO> items = (List<PanVO>) panService.selectPanList(searchVO);
        int totalCount = panService.selectPanListTotCnt(searchVO);
        model.addAttribute("items", items);
        model.addAttribute("total_cnt", totalCount);

        return "pan/panList";
    }

    @RequestMapping(value = "/deletePan.do"
                    ,method = RequestMethod.POST
                    ,produces = "application/json;charset=utf8")
    @ResponseBody
    public String deletePan(HttpServletRequest req,
                            Model model) throws Exception {
        String cmID = req.getParameter("cmID");
        PanVO inVO = new PanVO();
        inVO.setCmID(cmID);

        LOGGER.debug("------------------------------------------");
        LOGGER.debug("param : "+inVO);
        LOGGER.debug("------------------------------------------");

        int flag = panService.deletePan(inVO);
        JSONObject obj = new JSONObject();
        obj.put("flag", flag);
        return  obj.toString();
    }

}
