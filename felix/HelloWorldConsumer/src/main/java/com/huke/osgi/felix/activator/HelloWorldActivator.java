package com.huke.osgi.felix.activator;

import com.huke.osgi.felix.listener.HelloWorldConsumer;
import com.huke.osgi.felix.service.HelloWorld;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * @author: huke10591
 * @create: 2014/11/14
 * @since: 1.0.0
 */
public class HelloWorldActivator implements BundleActivator {

    private final static Log logger = LogFactory.getLog(HelloWorldConsumer.class);

    private HelloWorldConsumer consumer;

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        ServiceReference reference = bundleContext.getServiceReference(HelloWorld.class.getName());
        consumer = new HelloWorldConsumer((HelloWorld) bundleContext.getService(reference));
        consumer.startTimmer();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        consumer.stopTimer();
    }
}
