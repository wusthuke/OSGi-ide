package com.huke.osgi.felix.activator;

import com.huke.osgi.felix.service.HelloWorld;
import com.huke.osgi.felix.service.impl.HelloWorldImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author: huke10591
 * @create: 2014/11/13
 * @since: 1.0.0
 */
public class HelloWorldActivator  implements BundleActivator {

    private static final Log logger = LogFactory.getLog(HelloWorldActivator.class);

    private ServiceRegistration registration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        logger.info("Felix HelloWorld start...");
        registration = bundleContext.registerService(HelloWorld.class.getName(), new HelloWorldImpl(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        logger.info("Felix HelloWorld stop ...");
        registration.unregister();
    }
}
