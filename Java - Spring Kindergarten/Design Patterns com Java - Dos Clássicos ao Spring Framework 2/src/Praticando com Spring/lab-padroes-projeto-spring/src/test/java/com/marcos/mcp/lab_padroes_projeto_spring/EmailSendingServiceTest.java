package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Email;
import com.marcos.mcp.lab_padroes_projeto_spring.model.EmailPlatform;
import com.marcos.mcp.lab_padroes_projeto_spring.service.implementations.EmailSendingService;


    // Capturando Argumentos


    // Entendendo a função capto()

    /* 
        capto() é um método fornecido pelo Mockito que permite capturar os argumentos passados para um método durante a execução de um teste. Ele é usado em conjunto com o método verify() para verificar se um método foi chamado com os argumentos corretos.

        A annotation @Captor é usada para criar um captor de argumentos, que é uma instância de ArgumentCaptor. O ArgumentCaptor é uma classe genérica que pode ser parametrizada com o tipo do argumento que você deseja capturar.

    */


@ExtendWith(MockitoExtension.class)
public class EmailSendingServiceTest {
    
    @Mock
    private EmailPlatform emailPlatform;

    @InjectMocks
    private EmailSendingService emailSendingService;

    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Test
    void validateDataSentToPlataform(){
        
        String emailAddress = "marcos.bolinho@hotmail.com";
        String message = "Olá, tudo bem?";
        boolean formatHtml = false;

        emailSendingService.sendEmail(emailAddress, message, formatHtml);

        Mockito.verify(emailPlatform).sendEmail(emailCaptor.capture());

        Email capturedEmail = emailCaptor.getValue();

        Assertions.assertEquals(emailAddress, capturedEmail.getEmailAddress());
        Assertions.assertEquals(message, capturedEmail.getMessage());
        Assertions.assertEquals("TEXT", capturedEmail.getFormat().name());

    }


}
