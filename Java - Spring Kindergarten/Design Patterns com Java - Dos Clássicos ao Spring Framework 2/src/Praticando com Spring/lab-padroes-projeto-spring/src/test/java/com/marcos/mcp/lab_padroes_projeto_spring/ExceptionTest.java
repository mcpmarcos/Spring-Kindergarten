package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Account;
import com.marcos.mcp.lab_padroes_projeto_spring.model.TransferingBetweenAccounts;

public class ExceptionTest {
    
    @Test
    void validateTransferingBetweenAccounts(){
        
        Account originAccount = new Account("123456", 1000);
        Account destinationAccount = new Account("789012", 500);
        
        TransferingBetweenAccounts transfering = new TransferingBetweenAccounts();
         
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        transfering.transfer(originAccount, destinationAccount, -1));

        // Este assertion foi escrito para não passar. 
        
        // Assertions.assertDoesNotThrow(() -> 
        // transfering.transfer(originAccount, destinationAccount, -1));
    }
}
