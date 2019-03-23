package com.hr;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class LoggingAop {
    private Logger LOG = Logger.getLogger(this.getClass());

    // JoinPoint : parameter that retrieve information about the method.
    public void logging(JoinPoint joinPoint) {
        Signature method = joinPoint.getSignature();
        String methodName = method.getName();
        LOG.debug("******************************************");
        LOG.debug("methodName : "+methodName+" is calling");
        LOG.debug("******************************************");
    }
}
