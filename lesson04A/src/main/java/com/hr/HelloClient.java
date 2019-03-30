package com.hr;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloClient {

    private static Logger LOG = Logger.getLogger(HelloClient.class);

    public static void main(String[] args) {
        String configLocation = "applicationContext.xml";

        ApplicationContext context =
                new ClassPathXmlApplicationContext(configLocation);

        HelloWorldService helloClient = context.getBean(HelloWorldServiceImpl.class);
        System.out.println("=================================================");
        System.out.println(helloClient.sayHello());
        System.out.println("=================================================");
    }
}
