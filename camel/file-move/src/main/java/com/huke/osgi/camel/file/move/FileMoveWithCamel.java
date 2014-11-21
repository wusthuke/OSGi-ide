package com.huke.osgi.camel.file.move;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by huke10591 on 2014/11/18.
 */
public class FileMoveWithCamel {
    private static final Logger logger = LoggerFactory.getLogger(FileMoveWithCamel.class);

    public static void main(String[] args) throws Exception{
        CamelContext context = new DefaultCamelContext();

        final FileConvertProcessor processor = new FileConvertProcessor();

        logger.info("add routes ....");
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:e:/OSGi/_tmp/inbox").process(processor).to("file:e:/OSGi/_tmp/outbox");
            }
        });
        context.start();
        boolean loop = true;
        while (loop) {
            Thread.sleep(55000);
            logger.info("now become false");
            loop = false;
        }
        context.stop();
     }
}
