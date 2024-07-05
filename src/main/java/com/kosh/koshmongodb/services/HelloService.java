package com.kosh.koshmongodb.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getGreeting() {
        return "Hello world!";
    }
}