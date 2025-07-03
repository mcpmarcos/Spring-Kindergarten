package com.marcos.mcp.spring_security_jwt.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    // Não é uma forma restful, pois dentro do mesmo recurso(WelcomeController) temos 2 caracteristicas diferentes (2 URI's diferentes dentro de um mesmo recurso)


     @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }
    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }
}
