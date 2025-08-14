package com.fastcampus.resttemplatesandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestTemplateSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateSandboxApplication.class, args);
    }

}
