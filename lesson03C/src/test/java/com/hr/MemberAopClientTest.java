package com.hr;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class MemberAopClientTest {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private ApplicationContext context;

    @Before
    public void setup() {
        LOG.debug("================================================");
        LOG.debug("context : "+context);
        LOG.debug("================================================");
    }

    @Test
    public void memberAop() {
        MemberSvc memberSvc = (MemberSvc) context.getBean("memberProxy");
        memberSvc.do_save();
        memberSvc.insert();
    }


}
