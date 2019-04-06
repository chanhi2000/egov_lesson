package egovframework.example;

import egovframework.example.pan.service.EgovPanService;
import egovframework.example.pan.service.PanVO;
import egovframework.example.sample.service.SampleDefaultVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/egovframework/spring/context-*"})
public class PanServiceTest {

    private static Logger LOGGER = LoggerFactory.getLogger(PanDAOTest.class);

    @Autowired
    private EgovPanService panService;

    private PanVO vo01;
    private PanVO vo02;
    private PanVO vo03;

    @Before
    public void setup() {
        vo01 = new PanVO("chanhi2000_91", "a", "1234", "1", "10", "100", "1000", "chanhi2000@gmail.com");
        vo02 = new PanVO("chanhi2000_91", "b", "1234", "1", "20", "200", "2000", "chanhi2001@gmail.com");
        vo03 = new PanVO("chanhi2000_91", "c", "1234", "1", "30", "300", "3000", "chanhi2002@gmail.com");

        LOGGER.debug("======================================================");
        LOGGER.debug("panService bean Created: "+panService);
        LOGGER.debug("======================================================");
    }

    @Test
    public void service_canAddAndGet() throws Exception {
        SampleDefaultVO searchVO = new SampleDefaultVO();
        searchVO.setPageSize(10);
        searchVO.setPageIndex(1);
        searchVO.setSearchCondition("0");searchVO.setSearchKeyword("happy_");

        int totalCnt = panService.selectPanListTotCnt(searchVO);
        LOGGER.debug("======================================================");
        LOGGER.debug("totalCnt =  "+totalCnt);
        LOGGER.debug("======================================================");

        panService.deletePan(vo01);
        panService.deletePan(vo02);
        panService.deletePan(vo03);

        LOGGER.debug("======================================================");
        LOGGER.debug("delete");
        panService.deletePan(vo01);
        panService.deletePan(vo02);
        panService.deletePan(vo03);
        LOGGER.debug("======================================================");
        LOGGER.debug("add");
        panService.insertPan(vo01);
        LOGGER.debug("======================================================");
        LOGGER.debug("select");
        PanVO vsVO = panService.selectPan(vo01);
        panService.selectPan(vsVO);
        LOGGER.debug("======================================================");
        LOGGER.debug("compare "+(vsVO.equals(vo01) ? "succeeded" : "failed"));
        assertThat(vsVO, is(vo01));
        LOGGER.debug("======================================================");
    }
}
