package com.example.javabasedemo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class JavaBaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBaseDemoApplication.class, args);
    }

}
