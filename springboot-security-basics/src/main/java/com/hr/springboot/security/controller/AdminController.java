package com.hr.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/admin")
public class AdminController {

    @GetMapping("/msg")
    public String getMessage() {
        return "Welcome Admin !";
    }
}
