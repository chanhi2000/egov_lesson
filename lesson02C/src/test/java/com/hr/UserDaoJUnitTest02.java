package com.hr;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UserDaoJUnitTest02 {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        LOG.debug("00 setup");
    }

    @Test
    public void test01() {
        LOG.debug("test01");
    }

    @Test
    public void test02() {
        LOG.debug("test02");
    }

    @After
    public void tearDown() {
        LOG.debug("00 tearDown");
    }
}
