package br.com.example.challengebank.model;

public class Account {
    private final String customerName;
    private final String accountType;
    private double balance;

    public Account(String customerName, String accountType, double balance) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transfer(double amount) {
        balance -= amount;
    }
}