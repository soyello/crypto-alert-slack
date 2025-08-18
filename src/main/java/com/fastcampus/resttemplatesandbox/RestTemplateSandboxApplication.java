package com.fastcampus.resttemplatesandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class RestTemplateSandboxApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RestTemplateSandboxApplication.class, args);
        SpringApplication.exit(run);
    }

}
