package com.springproject.demo.Service.ServiceImpl;
import com.springproject.demo.Service.MyService2;
import org.springframework.stereotype.Service;

@Service    // here if you use @Service annotaions then you need not to create separate @ Bean annotations as in My Config as
            // @Service hepls spring to automatically detect and register as a bean during component scanning.
public class ServiceImplementation2 implements MyService2 {


    @Override
    public String sayHello(String name) {
        return "Hi" + name;
    }
}
