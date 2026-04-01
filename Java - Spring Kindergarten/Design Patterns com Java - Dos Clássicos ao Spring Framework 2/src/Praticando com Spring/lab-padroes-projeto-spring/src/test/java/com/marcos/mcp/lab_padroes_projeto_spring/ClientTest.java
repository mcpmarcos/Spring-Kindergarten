package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Client;
import com.marcos.mcp.lab_padroes_projeto_spring.model.Person;

public class ClientTest {
    
    @Test
    void mustCalculateAgeCorrectly(){
        Client client = new Client("Marcos");
        Assertions.assertEquals("Marcos", client.getName());

    }

    @Test
    void verifyAdultage(){
        Person marcos = new Person("Marcos", 38);
        Assertions.assertTrue(marcos.isAdult());
    }

}
