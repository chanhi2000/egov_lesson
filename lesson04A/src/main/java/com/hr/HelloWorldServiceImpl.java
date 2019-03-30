package com.hr;

public class HelloWorldServiceImpl implements HelloWorldService {
    private String name;
    public void setName(String name) { this.name = name; }

    @Override
    public String sayHello() {
        return "Hello "+name+"!!!";
    }
}
