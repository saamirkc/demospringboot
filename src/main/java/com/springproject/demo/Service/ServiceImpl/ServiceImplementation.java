package com.springproject.demo.Service.ServiceImpl;

import com.springproject.demo.Service.MyService;

public class ServiceImplementation implements MyService {
    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
}
