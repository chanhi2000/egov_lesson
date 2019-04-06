package egovframework.example;


import egovframework.example.pan.service.PanVO;
import egovframework.example.pan.service.impl.PanDAO;

import egovframework.example.sample.service.SampleDefaultVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/egovframework/spring/context-*"})
public class PanDAOTest {

    private static Logger LOGGER = LoggerFactory.getLogger(PanDAOTest.class);

    @Autowired
    private PanDAO panDAO;

    private PanVO vo01;
    private PanVO vo02;
    private PanVO vo03;

    @Before
    public void setup() {
        vo01 = new PanVO("chanhi2000_91", "a", "1234", "1", "10", "100", "1000", "chanhi2000@gmail.com");
        vo02 = new PanVO("chanhi2000_91", "b", "1234", "1", "20", "200", "2000", "chanhi2001@gmail.com");
        vo03 = new PanVO("chanhi2000_91", "c", "1234", "1", "30", "300", "3000", "chanhi2002@gmail.com");

        LOGGER.debug("======================================================");
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
        assertThat(vo01.getCmID(), is(voSelected.getCmID()));

        panDAO.updatePan(vo02);
        PanVO voSelected02 = panDAO.selectPan(vo02);
        LOGGER.debug("======================================================");
        LOGGER.debug("update "+(vo02.equals(voSelected02) ? "succeeded" : "failed"));
        LOGGER.debug("======================================================");
        assertThat(vo02.getCmID(), is(voSelected.getCmID()));

        panDAO.deletePan(vo02);
        LOGGER.debug("======================================================");
        LOGGER.debug("delete ");
        LOGGER.debug("======================================================");
        PanVO voDeleted = panDAO.selectPan(vo02);
        assertThat(voDeleted, is(nullValue()));
    }

    @Test
    public void panDao_canRetreiveList() throws Exception {
        LOGGER.debug("======================================================");
        LOGGER.debug("getList");
        SampleDefaultVO vo = new SampleDefaultVO();vo.setPageSize(10);vo.setPageIndex(1);
        List<PanVO> list = (List<PanVO>) panDAO.selectPanListPaged(vo);

        assertThat(list.size(), is(10));
        LOGGER.debug("item count = "+list.size());
        LOGGER.debug("======================================================");

        vo.setSearchCondition("0");vo.setSearchKeyword("happy");
        List<PanVO> listCond = (List<PanVO>) panDAO.selectPanListPaged(vo);
        LOGGER.debug(listCond.toString().replace("},", "},\n"));
        LOGGER.debug("search result count = "+listCond.size());
        LOGGER.debug("======================================================");
        boolean isWithinCount = listCond.size() <= panDAO.selectPanListTotCnt(vo);
        assertThat(isWithinCount , is(true));

    }
}
