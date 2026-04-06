package com.marcos.mcp.lab_padroes_projeto_spring.model;

public class Account {
    
    private String AccountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.AccountNumber = accountNumber;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return AccountNumber;
    }

    public int getBalance() {
        return balance;
    }

   
}
