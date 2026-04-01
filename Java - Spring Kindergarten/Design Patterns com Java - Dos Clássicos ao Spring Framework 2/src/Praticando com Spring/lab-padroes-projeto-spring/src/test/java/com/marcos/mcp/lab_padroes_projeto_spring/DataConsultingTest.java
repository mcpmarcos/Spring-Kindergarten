package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.marcos.mcp.lab_padroes_projeto_spring.model.DataBase;
import com.marcos.mcp.lab_padroes_projeto_spring.model.Person;

public class DataConsultingTest {
    
    @BeforeAll
    static void ConectionConfig(){
        DataBase.startConection();
    }

    @BeforeEach
    void insertDataTest(){
        DataBase.insertPersonOnDatabase(new Person("Larissa", 38));
    }

    @AfterEach
    void removeDataTest(){
        DataBase.removePersonOnDatabase(new Person("Larissa", 38));
    }

    @Test
    void returningDataValidate(){
        Assertions.assertTrue(true);
    }

    @Test
    void returningDataValidate2(){
        Assertions.assertNull(null);
    }

    @AfterAll
    static void finalizeConection(){
        DataBase.stopConection();
    }

}
