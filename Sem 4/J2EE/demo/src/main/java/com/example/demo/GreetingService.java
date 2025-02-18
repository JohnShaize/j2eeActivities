package com.example.demo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class GreetingService {

    @PostConstruct
    public void init() {
        System.out.println("GreetingService bean is initialized!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("GreetingService bean is destroyed!");
    }

    public String greet() {
        return "Hello, Spring Beans!";
    }
}
