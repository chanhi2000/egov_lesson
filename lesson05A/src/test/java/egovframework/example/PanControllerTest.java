package egovframework.example;

import egovframework.example.pan.service.PanVO;
import egovframework.example.pan.web.EgovPanController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/egovframework/spring/context-*"
                                    , "file:src/main/webapp/WEB-INF/config/egovframework/springmvc/dispatcher-servlet.xml"
})
public class PanControllerTest {
    private static Logger LOGGER = LoggerFactory.getLogger(PanDAOTest.class);

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Autowired
    private EgovPanController panController;

    private PanVO vo01;
    private PanVO vo02;
    private PanVO vo03;

    @Before
    public void setup() {
        vo01 = new PanVO("chanhi2000_91", "a", "1234", "1", "10", "100", "1000", "chanhi2000@gmail.com");
        vo02 = new PanVO("chanhi2000_91", "b", "1234", "1", "20", "200", "2000", "chanhi2001@gmail.com");
        vo03 = new PanVO("chanhi2000_91", "c", "1234", "1", "30", "300", "3000", "chanhi2002@gmail.com");

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        LOGGER.debug("======================================================");
        LOGGER.debug("context: "+context);
        LOGGER.debug("mockMvc bean Created: "+mockMvc);
        LOGGER.debug("======================================================");
    }

    @Test
    public void panControllerTest() throws Exception {
        MockHttpServletRequestBuilder cMsg01 = get("/selectPanList.do?search_word=happy");
        mockMvc.perform(cMsg01)
                .andExpect(status().isOk());

        MockHttpServletRequestBuilder cMsg02 = get("/selectPan.do?cmID=chanhi2000_91");
        mockMvc.perform(cMsg02)
                .andExpect(status().isOk());
    }
}
