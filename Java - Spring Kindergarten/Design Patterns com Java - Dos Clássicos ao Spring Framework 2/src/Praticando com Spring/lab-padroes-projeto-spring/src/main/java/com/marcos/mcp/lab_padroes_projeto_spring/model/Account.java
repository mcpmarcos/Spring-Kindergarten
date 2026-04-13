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

    public void payBill(int payingAmount){
        validateBalance(payingAmount);
        debiting(payingAmount);
        sendCreditToCompany(payingAmount);
    }

    public void debiting(int payingAmount) {
        this.balance -= payingAmount;
        // this.balance = this.balance - payingAmount;

    }

    public void validateBalance(int payingAmount) {
        if (this.balance < payingAmount) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o pagamento.");
        }
    }

    public void sendCreditToCompany(int payingAmount) {

    }
}
