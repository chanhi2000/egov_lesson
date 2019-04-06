package egovframework.example.pan.service.impl;

import egovframework.example.pan.service.EgovPanService;
import egovframework.example.pan.service.PanVO;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("panService")
public class PanServiceImpl extends EgovAbstractServiceImpl implements EgovPanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PanServiceImpl.class);

    // TODO ibatis 사용
    @Resource(name = "panDAO")
    private PanDAO panDAO;
    // TODO mybatis 사용
    //  @Resource(name="sampleMapper")
    //	private SampleMapper sampleDAO;

    /** ID Generation */
    @Resource(name = "egovIdGnrService")
    private EgovIdGnrService egovIdGnrService;

    @Override
    public String insertPan(PanVO vo) throws Exception {
        /** ID Generation Service */
        LOGGER.debug("==========================================");
        LOGGER.debug("pan to add: "+vo.toString());
        LOGGER.debug("==========================================");
        return panDAO.insertPan(vo);
    }

    @Override
    public int updatePan(PanVO vo) throws Exception {
        LOGGER.debug("==========================================");
        LOGGER.debug("pan to update: "+vo.toString());
        LOGGER.debug("==========================================");
        return panDAO.updatePan(vo);
    }

    @Override
    public int deletePan(PanVO vo) throws Exception {
        return panDAO.deletePan(vo);
    }

    @Override
    public PanVO selectPan(PanVO vo) throws Exception {
        PanVO resultVO = panDAO.selectPan(vo);
        if (resultVO == null) throw processException("info.nodata.msg");
        return resultVO;
    }

    @Override
    public List<?> selectPanList(SampleDefaultVO searchVO) throws Exception {
        return panDAO.selectPanList(searchVO);
    }

    @Override
    public int selectPanListTotCnt(SampleDefaultVO searchVO) {
        return panDAO.selectPanListTotCnt(searchVO);
    }
}