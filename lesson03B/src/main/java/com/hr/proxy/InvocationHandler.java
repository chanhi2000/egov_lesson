package com.hr.proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class InvocationHandler implements java.lang.reflect.InvocationHandler {
    Logger LOG = Logger.getLogger(this.getClass());

    private Object target;
    public InvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(target, args);
        if(ret instanceof String) {
            return ((String)ret).toUpperCase();
        }
        return ret;
    }
}
