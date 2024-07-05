package com.kosh.koshmongodb;

import org.springframework.boot.SpringApplication;

public class TestKoshMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.from(KoshMongoDbApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
