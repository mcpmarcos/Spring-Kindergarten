package com.marcos.mcp.lab_padroes_projeto_spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.marcos.mcp.lab_padroes_projeto_spring.model.NumberGenerator;

@ExtendWith(MockitoExtension.class)
public class NumberGeneratorTest {
    
    @Test
    void finiteSizeRandomNumberGeneratorTest(){

        MockedStatic<NumberGenerator> mockedStaticClas = Mockito.mockStatic(NumberGenerator.class);    
    }

}
