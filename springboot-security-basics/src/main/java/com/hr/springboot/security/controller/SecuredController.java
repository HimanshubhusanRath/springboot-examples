package com.hr.springboot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecuredController {

    @GetMapping("/msg")
    public String getMessage() {
        return "I am a secured message";
    }

    @PreAuthorize("hasRole('SUPPORT')")
    @GetMapping("/sup")
    public String getSupportMessage() {
        return "Hello Support User !!";
    }
}
