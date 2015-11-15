package com.bachiscoding.hadoop.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by winiex on 10/18/2015.
 */
public class DynamicProxyMain {

    public static void main(String[] args) {
        InvocationHandler handler = new ProtocolInvocationHandler(new ProtocolImpl());
        Protocol proxy = (Protocol) Proxy.newProxyInstance(
                Protocol.class.getClassLoader(), new Class[] {Protocol.class}, handler
        );

        System.out.println(proxy.getProxyValue());
    }
}
