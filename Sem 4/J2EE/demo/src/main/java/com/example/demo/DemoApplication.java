package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


		GreetingService service1 = context.getBean(GreetingService.class);
		GreetingService service2 = context.getBean(GreetingService.class);


		System.out.println(service1 == service2);


		context.close();
	}
}
