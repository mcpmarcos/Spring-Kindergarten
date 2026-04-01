package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


public class ConditionalTest {
   
    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "marcos")
    void validarAlgoEmMeuUsuario(){

        Assertions.assertEquals(10, 5 + 5);
    }
    
    @Test
    @DisabledIfEnvironmentVariable(named = "USER", matches = "root")
    void desabilitarAlgoEmMeuUsuario(){

        Assertions.assertEquals(10, 5 + 5);
    }
   
    @Test
    @EnabledOnOs(OS.LINUX)
    void habilitarAlgoEmMeuUsuario(){

        Assertions.assertEquals(10, 5 + 5);
    }
    
    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void validarJRE(){

        Assertions.assertEquals(10, 5 + 5);
    }
    
    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_21)
    void testarJRE(){

        Assertions.assertEquals(10, 5 + 5);
    }



}
