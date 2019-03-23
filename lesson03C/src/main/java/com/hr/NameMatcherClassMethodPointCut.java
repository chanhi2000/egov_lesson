package com.hr;

import org.apache.log4j.Logger;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

public class NameMatcherClassMethodPointCut extends NameMatchMethodPointcut {

    public static Logger LOG = Logger.getLogger(NameMatcherClassMethodPointCut.class);
    public void setMappedClassName(String mappedName) { // for bean injection
        this.setClassFilter(new SimpleClassFilter(mappedName));
    }

    public static class SimpleClassFilter implements ClassFilter {
        String mappedName;
        public SimpleClassFilter(String mappedName) {
            this.mappedName = mappedName;
        }

        @Override public boolean matches(Class<?> clazz) {
            LOG.debug("1. pointcut mappedName: "+mappedName);
            LOG.debug("2. pointcut clazz.getSimpleName(): "+clazz.getSimpleName());
            LOG.debug("3. pointcut PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName(): "+PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName()));
            return PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName());
        }
    }

}
