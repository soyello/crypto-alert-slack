package com.fastcampus.resttemplatesandbox.contoller;

import com.fastcampus.resttemplatesandbox.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/api/v1/test")
    public String helloWorld() {
        return testService.getTest();
    }
}
