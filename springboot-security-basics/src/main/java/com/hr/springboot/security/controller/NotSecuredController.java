package com.hr.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/not-secure")
public class NotSecuredController {

    @GetMapping("/msg")
    public String getMessage() {
        return "I am a non-secured message";
    }
}
