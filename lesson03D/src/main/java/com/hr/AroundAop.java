package com.hr;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAop {
    private Logger LOG = Logger.getLogger(this.getClass());

    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object ret = pjp.proceed();

        stopWatch.stop();
        LOG.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LOG.debug("time taken to run method, \""+methodName+"\' : "+stopWatch.getTotalTimeMillis()+"(ms)");
        LOG.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return pjp;
    }
}
