package com.huke.osgi.felix.listener;


import com.huke.osgi.felix.service.HelloWorld;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: huke10591
 * @create: 2014/11/14
 * @since: 1.0.0
 */
public class HelloWorldConsumer implements ActionListener {

    private static final Log logger = LogFactory.getLog(HelloWorldConsumer.class);

    private final HelloWorld helloWorld;
    private final Timer timer;

    public HelloWorldConsumer(HelloWorld helloWorld) {
        super();
        this.helloWorld = helloWorld;
        timer = new Timer(1000, this);
        logger.info("Felix HelloWorldConsumer has bean instanced...");
    }

    public void startTimmer() {
        logger.info("Felix HellWorldConsumer start Timer..");
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        helloWorld.sayHello();
    }
}
