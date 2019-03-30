package com.hr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloClient {
    private static Logger LOG = LoggerFactory.getLogger(HelloClient.class);

    public static void main(String[] args) {
        String configLocation = "applicationContext.xml";

        ApplicationContext context =
                new ClassPathXmlApplicationContext(configLocation);

        HelloWorldService helloClient = context.getBean(HelloWorldServiceImpl.class);
        LOG.debug("=================================================");
        LOG.debug(helloClient.sayHello());
        LOG.debug("=================================================");
    }
}
