package com.marcos.mcp.lab_padroes_projeto_spring.model;

public class Email {
    
    private String emailAddress;

    private String message;

    private FormatEnum format;

    public Email(String emailAddress, String message, FormatEnum format) {
        this.emailAddress = emailAddress;
        this.message = message;
        this.format = format;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FormatEnum getFormat() {
        return format;
    }

}
