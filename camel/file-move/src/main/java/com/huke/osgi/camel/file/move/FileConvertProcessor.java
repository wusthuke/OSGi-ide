package com.huke.osgi.camel.file.move;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author: huke10591
 * @Create: 2014/11/18
 */
public class FileConvertProcessor implements Processor {
    private static final Logger logger = LoggerFactory.getLogger(FileConvertProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {


        InputStream body = exchange.getIn().getBody(InputStream.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(body));

        StringBuffer sb = new StringBuffer("");
        String line = null;

        line = reader.readLine();
        line = reader.readLine();
        while(line != null) {
            sb.append(line + " ");
            line = reader.readLine();
        }
        reader.close();
        exchange.getOut().setHeader(Exchange.FILE_NAME, "converted.txt");
        logger.info(sb.toString());
        exchange.getOut().setBody(sb.toString());
    }
}
