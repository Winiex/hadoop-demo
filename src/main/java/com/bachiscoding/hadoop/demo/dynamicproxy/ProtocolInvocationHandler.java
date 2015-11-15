package com.bachiscoding.hadoop.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by winiex on 10/18/2015.
 */
public class ProtocolInvocationHandler implements InvocationHandler {

    private Object target;

    public ProtocolInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
