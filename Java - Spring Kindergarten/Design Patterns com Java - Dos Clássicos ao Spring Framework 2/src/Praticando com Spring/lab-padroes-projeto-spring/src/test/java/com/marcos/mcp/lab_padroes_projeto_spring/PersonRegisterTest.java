package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Endereco;
import com.marcos.mcp.lab_padroes_projeto_spring.model.Person;
import com.marcos.mcp.lab_padroes_projeto_spring.service.implementations.CorreioServiceAPI;
import com.marcos.mcp.lab_padroes_projeto_spring.service.implementations.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class PersonRegisterTest {
    

    /*
    
    A essência do meu objetivo é injetar um mock da classe CorreioServiceAPI na classe PersonService, para que eu possa controlar o comportamento do método getDadosLocalizacao() durante os testes.

    Para isso, utilizo a anotação @Mock para criar um mock da classe CorreioServiceAPI e a anotação @InjectMocks para injetar esse mock na classe PersonService. Dessa forma, quando o método personRegister() for chamado durante os testes, ele utilizará o mock da CorreioServiceAPI em vez de uma implementação real.

    */


    @InjectMocks // Injeta os mocks criados na classe de teste para a classe PersonService
    private PersonService personService;

    @Mock
    CorreioServiceAPI correioServiceAPI;

    // Alternativa para inicializar os mocks sem usar a anotação @ExtendWith(MockitoExtension.class) 

    //@BeforeAll
    // void setup(){
    //     MockitoAnnotations.initMocks(this);
    // }

    // private CorreioServiceAPI correioServiceAPI = Mockito.mock(CorreioServiceAPI.class);

    @Test
    void validarDadosDeCadastro(){

        Endereco minhaRua = new Endereco("SP", "São Paulo", "Casa");
    
        Mockito.when(correioServiceAPI.getDadosLocalizacao("Marcos C. Pacheco")).thenReturn(minhaRua);
        
        Person p = personService.personRegister("Marcos C. Pacheco", 37);

        assertEquals("Marcos C. Pacheco", p.getName());
    
        assertEquals(37, p.getAge());
    
        assertEquals(minhaRua, p.getEndereco());
        
    }

    @Test
    void launchExceptionWhenApiCorreiosIsCalled(){

        Endereco minhaRua = new Endereco("SP", "São Paulo", "Casa");
    
        Mockito.when(correioServiceAPI.getDadosLocalizacao(anyString())).thenThrow(IllegalArgumentException.class);
        
        Person p = personService.personRegister("Marcos C. Pacheco", 37);

        // assertEquals("Marcos C. Pacheco", p.getName());
    
        // assertEquals(37, p.getAge());
    
        // assertEquals(minhaRua, p.getEndereco());
        
    }
    
    @Test
    void launchExceptionWhenApiCorreiosIsCalled2(){

        Endereco minhaRua = new Endereco("SP", "São Paulo", "Casa");
    
        Mockito.when(correioServiceAPI.getDadosLocalizacao(anyString())).thenThrow(IllegalArgumentException.class);
        
        // Person p = personService.personRegister("Marcos C. Pacheco", 37);

        assertThrows(IllegalArgumentException.class, () -> {

            personService.personRegister("Marcos C. Pacheco", 37);
        });
        
    }
    
    @Test
    void launchExceptionWhenApiCorreiosIsCalled3(){

        Mockito.doThrow(IllegalArgumentException.class).when(correioServiceAPI).getDadosLocalizacao(anyString());

        assertThrows(IllegalArgumentException.class, () -> {

            personService.personRegister("Marcos C. Pacheco", 37);
        });
        
    }

}
