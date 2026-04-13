package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Message;
import com.marcos.mcp.lab_padroes_projeto_spring.service.implementations.SendMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@ExtendWith(MockitoExtension.class)
public class SendMessageTest {
    
    @Spy
    private SendMessage sendMessage;

    @Mock
    private Message message;

    @Test
    void verifyingClassBehavior() {
       
       Mockito.verifyNoInteractions(sendMessage);
       
       Message message = new Message("1", "Hello, World!");
       sendMessage.addMessage(message);
       
       Mockito.verify(sendMessage).addMessage(message);
       
       assertFalse(sendMessage.getMsg().isEmpty());

       
        // sendMessage = new SendMessage();
        // sendMessage.addMessage(message);

        // assertEquals(false, sendMessage.getMsg().isEmpty());
        // assertEquals(1, sendMessage.getMsg().size());
        // assertEquals(true, sendMessage.getMsg().contains(message));
    }


}
