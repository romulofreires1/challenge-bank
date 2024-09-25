package br.com.example.challengebank;

import java.util.Scanner;

public class JuniorDeveloper {
    public static void main(String[] args) {
        String customerName = "Peter Parker";
        String accountType = "Checking";
        double balance = 1500.00;

        System.out.println("*****************************");
        System.out.printf("Customer: %s%n", customerName);
        System.out.printf("Account Type: %s%n", accountType);
        System.out.printf("Balance: $%.2f%n", balance);
        System.out.println("*****************************");

        String menu = """  
                
                1 - Check Balance
                2 - Deposit Amount
                3 - Transfer Amount
                4 - Exit
                
                Please enter your choice:""";

        byte input = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(menu);
            input = scanner.nextByte();

            if (input == 1) {
                System.out.printf("Your current balance is $%.2f%n", balance);
            } else if (input == 2) {
                System.out.println("Enter the amount to deposit:");
                double amountReceived = scanner.nextDouble();
                balance += amountReceived;
                System.out.printf("Your new balance after deposit is $%.2f%n", balance);
            } else if (input == 3) {
                System.out.println("Enter the amount to transfer:");
                double transferAmount = scanner.nextDouble();
                if (transferAmount > balance) {
                    System.out.println("Insufficient balance for this transfer.");
                } else {
                    balance -= transferAmount;
                    System.out.printf("Your new balance after transfer is $%.2f%n", balance);
                }
            } else if (input == 4) {
                System.out.println("Thank you! Exiting the program.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}