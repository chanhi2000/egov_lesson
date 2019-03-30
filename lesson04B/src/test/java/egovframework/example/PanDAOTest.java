package egovframework.example;


import egovframework.example.pan.service.PanVO;
import egovframework.example.pan.service.impl.PanDAO;
import egovframework.example.sample.service.impl.SampleDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/egovframework/spring/context-*"})
public class PanDAOTest {

    private static Logger LOGGER = LoggerFactory.getLogger(PanDAOTest.class);

//    @Autowired
//    private SampleDAO sampleDAO;

    @Autowired
    private PanDAO panDAO;

    private PanVO vo01;
    private PanVO vo02;
    private PanVO vo03;

    @Before
    public void setup() {
        vo01 = new PanVO("chanhi2000_91", "a", "1234", "1", "10", "100", "1000", "chanhi2000@gmail.com");
        vo02 = new PanVO("chanhi2000_92", "b", "1234", "1", "20", "200", "2000", "chanhi2001@gmail.com");
        vo03 = new PanVO("chanhi2000_93", "c", "1234", "1", "30", "300", "3000", "chanhi2002@gmail.com");

        LOGGER.debug("======================================================");
//        LOGGER.debug("sampleDao bean Created: "+sampleDAO);
        LOGGER.debug("panDao bean Created: "+panDAO);
        LOGGER.debug("======================================================");
    }

    @Test
    public void panDaoTest() throws Exception {
        LOGGER.debug("======================================================");
        LOGGER.debug("addAndGet");
        LOGGER.debug("======================================================");
        panDAO.insertPan(vo01);
        PanVO voSelected = panDAO.selectPan(vo01);
        LOGGER.debug("======================================================");
        LOGGER.debug("add "+(vo01.equals(voSelected) ? "succeeded" : "failed"));
        LOGGER.debug("======================================================");
    }
}
