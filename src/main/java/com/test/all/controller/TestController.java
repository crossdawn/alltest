package com.test.all.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/monitor")
@RestController

public class TestController {
    @GetMapping("/test")
    public String monitorHttp() {
        return "OK";
    }
}
