package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Person;

public class AssertionsTest {
    
    @Test
    void validarLancamentos(){
        int[] primeirolancamento = {1, 2, 3, 4, 5};
        int[] segundolancamento = {1, 8, 9, 10, 12};

        Assertions.assertArrayEquals(primeirolancamento, segundolancamento);
    }
    
    @Test
    void validarObjetoNulo(){
        Person p = null;

        Assertions.assertNull(p);

        p = new Person("Marcos");

        Assertions.assertNotNull(p);
    }

    @Test
    void validarTiposDiferentes(){
        double v1 = 5.0;
        double v2 = 8.5;

        Assertions.assertNotEquals(v1,v2);
    }
}
