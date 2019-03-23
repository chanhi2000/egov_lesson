package com.hr.proxy;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloUppercaseProxyTest {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Test
    public void helloUppercaseProxyTest() {
        Hello proxiedHello = new HelloUppercase(new HelloTarget());
        LOG.debug("==========================================");
        LOG.debug("hello.sayHi(\"HR\") = "+proxiedHello.sayHi("HR"));
        LOG.debug("==========================================");
        assertThat(proxiedHello.sayHi("HR"), is("HI HR"));
        LOG.debug("==========================================");
        LOG.debug("hello.sayHello(\"HR\") = "+proxiedHello.sayHello("HR"));
        LOG.debug("==========================================");
        assertThat(proxiedHello.sayHello("HR"), is("HELLO HR"));
        LOG.debug("==========================================");
        LOG.debug("hello.sayThankYou(\"HR\") = "+proxiedHello.sayThankYou("HR"));
        LOG.debug("==========================================");
        assertThat(proxiedHello.sayThankYou("HR"), is("THANKYOU HR"));
    }
}
