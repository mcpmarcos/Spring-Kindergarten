package com.mcp.dio.myfirstwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mcp.dio.myfirstwebapi.controller.WelcomeController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My First Web API", version = "1.0", description = "Testando o Swagger"))
public class MyFirstWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstWebApiApplication.class, args);
		WelcomeController controller = new WelcomeController();
		System.out.println(controller.welcome());
		
	}

	
}

