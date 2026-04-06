package com.marcos.mcp.lab_padroes_projeto_spring.model;

public class TransferingBetweenAccounts {
    
     public void transfer(Account originAccount, Account destinationAccount, double value){
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }
    }
}
