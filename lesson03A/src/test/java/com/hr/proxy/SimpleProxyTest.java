package com.hr.proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SimpleProxyTest {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Test
    public void simpleProxy() {
        Hello hello = new HelloTarget();
        LOG.debug("==========================================");
        LOG.debug("hello.sayHi(\"HR\") = "+hello.sayHi("HR"));
        LOG.debug("==========================================");
        assertThat(hello.sayHi("HR"), is("Hi HR"));
        LOG.debug("==========================================");
        LOG.debug("hello.sayHello(\"HR\") = "+hello.sayHello("HR"));
        LOG.debug("==========================================");
        assertThat(hello.sayHello("HR"), is("Hello HR"));
        LOG.debug("==========================================");
        LOG.debug("hello.sayThankYou(\"HR\") = "+hello.sayThankYou("HR"));
        LOG.debug("==========================================");
        assertThat(hello.sayThankYou("HR"), is("ThankYou HR"));
    }
}
