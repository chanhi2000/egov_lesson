package com.hr;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

// Advice
public class MemberAop implements MethodInterceptor {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String method = invocation.getMethod().getName();
        LOG.debug("******************************************");
        LOG.debug("method: "+method + " will execute");
        Object result = invocation.proceed();
        LOG.debug("method: "+method + " did execute");
        LOG.debug("******************************************");
        return result;
    }
}
