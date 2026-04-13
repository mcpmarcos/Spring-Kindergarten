package com.marcos.mcp.lab_padroes_projeto_spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Account;

@ExtendWith(MockitoExtension.class)
public class AccountTest {
    
    @Spy
    private Account account = new Account("666", 10000);

    @Test
    void validatingOrderOfMethodCalls(){

        // Existe uma classe no mockito chamada InOrder, que é responsável por validar a ordem de chamadas dos métodos.

        account.payBill(300);

        InOrder inOrder = Mockito.inOrder(account);

        inOrder.verify(account).payBill(300); // Podemos também passar algum valor qualquer usando o ArgumentMatchers, como por exemplo: 

        // inOrder.verify(account).payBill(ArgumentMatchers.anyInt());

        inOrder.verify(account).validateBalance(300);
        inOrder.verify(account).debiting(300);
        inOrder.verify(account).sendCreditToCompany(300);
    }

    @Test
    void validatingAmountOfMethodCalls(){

        account.validateBalance(500);
        account.validateBalance(250);
        account.validateBalance(300);

        Mockito.verify(account, Mockito.times(3)).validateBalance(ArgumentMatchers.anyInt());
    }

    @Test
    void returningTrueForAnyValueInBalanceValidation(){


        Mockito.doNothing().when(account).validateBalance(ArgumentMatchers.anyInt());
        account.validateBalance(3500);
    }
    
}
