package com.marcos.mcp.lab_padroes_projeto_spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ListTest {
    
    @Mock
    private List<String> letters;

    @Test
    void addItemToList(){
        Mockito.when(letters.get(0)).thenReturn("B");
        Assertions.assertEquals("B", letters.get(0));
    }


}
