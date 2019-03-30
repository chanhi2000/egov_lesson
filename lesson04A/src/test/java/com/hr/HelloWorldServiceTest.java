package com.hr;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldServiceTest {
    private static Logger LOG = LoggerFactory.getLogger(HelloWorldServiceTest.class);
    private ApplicationContext context;

    @Before
    public void setup() {
        String configLocation = "applicationContext.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("==========================================");
        System.out.println("context : " + context);
        System.out.println("==========================================");
    }

    @Test
    public void applicationContextCreated() {

    }
}
