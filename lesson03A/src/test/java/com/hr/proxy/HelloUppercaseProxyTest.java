package com.hr.proxy;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloUppercaseProxyTest {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Test
    public void helloUppercaseProxyTest() {
        Hello proxyedHello = new HelloUppercase(new HelloTarget());
        LOG.debug("==========================================");
        LOG.debug("hello.sayHi(\"HR\") = "+proxyedHello.sayHi("HR"));
        LOG.debug("==========================================");
        assertThat(proxyedHello.sayHi("HR"), is("HI HR"));
        LOG.debug("==========================================");
        LOG.debug("hello.sayHello(\"HR\") = "+proxyedHello.sayHello("HR"));
        LOG.debug("==========================================");
        assertThat(proxyedHello.sayHello("HR"), is("HELLO HR"));
        LOG.debug("==========================================");
        LOG.debug("hello.sayThankYou(\"HR\") = "+proxyedHello.sayThankYou("HR"));
        LOG.debug("==========================================");
        assertThat(proxyedHello.sayThankYou("HR"), is("THANKYOU HR"));
    }
}
