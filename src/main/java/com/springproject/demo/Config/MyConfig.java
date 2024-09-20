package com.springproject.demo.Config;

import com.springproject.demo.Service.MyService;
import com.springproject.demo.Service.ServiceImpl.ServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyService myService(){
        return new ServiceImplementation();
    }
}

