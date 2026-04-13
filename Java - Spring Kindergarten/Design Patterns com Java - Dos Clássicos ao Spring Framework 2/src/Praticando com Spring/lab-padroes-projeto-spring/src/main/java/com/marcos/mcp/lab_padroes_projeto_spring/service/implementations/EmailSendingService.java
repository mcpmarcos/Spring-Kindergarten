package com.marcos.mcp.lab_padroes_projeto_spring.service.implementations;

import java.text.Format;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Email;
import com.marcos.mcp.lab_padroes_projeto_spring.model.EmailPlatform;
import com.marcos.mcp.lab_padroes_projeto_spring.model.FormatEnum;

public class EmailSendingService {
    
    private EmailPlatform emailPlatform;

    // public EmailSendingMessage(EmailPlatform emailPlatform) {
    //     this.emailPlatform = emailPlatform;
    // }

    public void sendEmail(String emailAddress, String message, boolean formatHtml) {
        
        Email email = null;
        
        if (formatHtml) {
            email = new Email(emailAddress, message, FormatEnum.HTML);
        } else {

            email = new Email(emailAddress, message, FormatEnum.TEXT);
        }

        emailPlatform.sendEmail(email);
    }

}
