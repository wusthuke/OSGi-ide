package com.huke.osgi.http.jetty;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @Author: huke10591
 * @Create: 2014/11/19
 */
public class HttpToFileRoute {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("jetty:http://127.0.0.1:8080/hello").process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received Message: " + exchange.getIn());
                        System.out.println(exchange.getIn().getBody(String.class));
                    }
                });
            }
        });

        context.start();
        Thread.sleep(30 * 1000);
        context.stop();
    }
}
