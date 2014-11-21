package com.huke.osgi.felix.service.impl;

import com.huke.osgi.felix.service.HelloWorld;

/**
 * @author: huke10591
 * @create: 2014/11/14
 * @since: 1.0.0
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello() {
        System.out.println("felix , hello!");
    }
}
