package com.hr;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")

public class AspectJTest {
    private Logger LOG = Logger.getLogger(this.getClass());
    @Autowired
    private ApplicationContext context;

    @Before
    public void setup() {

        LOG.debug("==========================================");
        LOG.debug("context : "+context);
        LOG.debug("==========================================");
    }

    @Test
    public void aspectJTest() {
        CommonDao dao = (CommonDao) context.getBean("dao");
        dao.do_retrieve();
        dao.do_delete();
        dao.do_save();
        dao.do_update();
    }
}
