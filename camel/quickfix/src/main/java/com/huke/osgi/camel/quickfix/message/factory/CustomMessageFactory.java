package com.huke.osgi.camel.quickfix.message.factory;

import quickfix.DefaultMessageFactory;
import quickfix.Message;

/**
 * @Author: huke10591
 * @Create: 2014/11/20
 */
public class CustomMessageFactory extends DefaultMessageFactory {

    @Override
    public Message create(String beginString, String msgType) {

        System.out.println("beginString: " + beginString);
        System.out.println("msgType: " + msgType);

        return super.create(beginString, msgType);
    }
}
