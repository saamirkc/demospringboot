package com.springproject.demo.Config;

import com.springproject.demo.Service.MyService;
import com.springproject.demo.Service.ServiceImpl.ServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
@Configuration
public class MyConfig {
    @Bean
    public MyService myService(){
        return new ServiceImplementation();
    }
}

//Since ServiceImplementation2 is annotated with @Service, it will be automatically detected and registered as a bean
// so for MyService 2 no need to crate @Bean .

