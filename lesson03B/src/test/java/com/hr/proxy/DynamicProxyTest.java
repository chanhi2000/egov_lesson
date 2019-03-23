package com.hr.proxy;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DynamicProxyTest {
    Logger LOG = Logger.getLogger(this.getClass());

    @Test
    public void dynamicProxyTest() {
        Hello proxiedHello = (Hello)Proxy.newProxyInstance( getClass().getClassLoader(),        // dynamically generated proxy class loader
                                                            new Class[]{Hello.class},           // interface to which target will be implemented
                                                            new InvocationHandler(new HelloTarget()) ); // class to invoke class to be delegated

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
