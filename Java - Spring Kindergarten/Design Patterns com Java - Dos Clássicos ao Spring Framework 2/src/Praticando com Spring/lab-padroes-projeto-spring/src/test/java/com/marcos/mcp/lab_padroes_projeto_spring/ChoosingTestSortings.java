package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ChoosingTestSortings {
    
    // @Order(5)
    @DisplayName("E")
    @Test
    void validateA(){
        Assertions.assertTrue(true);
    }
    
    // @Order(4)
    @DisplayName("D")
    @Test
    void validateB(){
        Assertions.assertTrue(true);
    }
    
    // @Order(3)
    @DisplayName("C")
    @Test
    void validateC(){
        Assertions.assertTrue(true);
    }
    
    // @Order(2)
    @DisplayName("B")
    @Test
    void validateD(){
        Assertions.assertTrue(true);
    }
    
    // @Order(1)
    @DisplayName("A")
    @Test
    void validateE(){
        Assertions.assertTrue(true);
    }


}
