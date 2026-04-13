package com.marcos.mcp.lab_padroes_projeto_spring.model;

public class EmailPlatform {
    

    public void sendEmail(Email email) {
        System.out.println("Enviando email para: " + email.getEmailAddress());
        System.out.println("Mensagem: " + email.getMessage());
        System.out.println("Formato: " + email.getFormat());
    }

}
