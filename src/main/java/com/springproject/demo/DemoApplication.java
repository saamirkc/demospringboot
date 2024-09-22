package com.springproject.demo;

import com.springproject.demo.Service.MyService;
import com.springproject.demo.Service.MyService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
	@Autowired
	private MyService myService;

    @Autowired
	private MyService2 myService2;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		String name=myService.greet("Samir !");
		System.out.println(name);

		String name2=myService2.sayHello("samir !");
		System.out.println(name2);
	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(myService.greet("samir !"));
//
//	}
}
