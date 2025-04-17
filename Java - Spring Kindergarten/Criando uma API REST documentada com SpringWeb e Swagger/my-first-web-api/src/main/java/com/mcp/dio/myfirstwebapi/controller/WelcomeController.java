package com.mcp.dio.myfirstwebapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    
    @GetMapping("hello")
    public String welcome(){
        return "Welcome to my Spring Boot Web API";
    }
 }
