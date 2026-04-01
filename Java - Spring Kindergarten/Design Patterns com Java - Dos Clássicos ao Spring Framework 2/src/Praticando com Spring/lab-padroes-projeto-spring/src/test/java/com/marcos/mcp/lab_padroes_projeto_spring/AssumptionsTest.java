package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTest {
    
    @Test
    void validarAlgoEmMeuUsuario(){

        Assumptions.assumeTrue("marcos.pacheco".equals(System.getenv("USER")));
        Assertions.assertEquals(10, 5 + 5);
    }

}
