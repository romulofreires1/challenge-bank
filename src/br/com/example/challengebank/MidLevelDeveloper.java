package br.com.example.challengebank;

import br.com.example.challengebank.model.Account;
import br.com.example.challengebank.model.MenuOption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MidLevelDeveloper {
    public static void main(String[] args) {
        Account account = new Account("Peter Parker", "Checking", 1500.00);
        displayAccountInfo(account);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MenuOption option = displayMenu(scanner);
            if (option == null) continue;

            switch (option) {
                case CHECK_BALANCE:
                    checkBalance(account);
                    break;

                case DEPOSIT:
                    depositAmount(scanner, account);
                    break;

                case TRANSFER:
                    transferAmount(scanner, account);
                    break;

                case EXIT:
                    System.out.println("Thank you! Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayAccountInfo(Account account) {
        System.out.println("*****************************");
        System.out.printf("Customer: %s%n", account.getCustomerName());
        System.out.printf("Account Type: %s%n", account.getAccountType());
        System.out.printf("Balance: $%.2f%n", account.getBalance());
        System.out.println("*****************************");
    }

    private static MenuOption displayMenu(Scanner scanner) {
        String menu = """  
                
                1 - Check Balance  
                2 - Deposit Amount  
                3 - Transfer Amount  
                4 - Exit  
                
                Please enter your choice:""";

        System.out.println(menu);
        try {
            byte input = scanner.nextByte();
            return MenuOption.fromValue(input);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            return null;
        }
    }

    private static void checkBalance(Account account) {
        System.out.printf("Your current balance is $%.2f%n", account.getBalance());
    }

    private static void depositAmount(Scanner scanner, Account account) {
        System.out.println("Enter the amount to deposit:");
        try {
            double amountReceived = scanner.nextDouble();
            if (amountReceived < 0) {
                System.out.println("Deposit amount must be positive.");
            } else {
                account.deposit(amountReceived);
                System.out.printf("Your new balance after deposit is $%.2f%n", account.getBalance());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
    }

    private static void transferAmount(Scanner scanner, Account account) {
        System.out.println("Enter the amount to transfer:");
        try {
            double transferAmount = scanner.nextDouble();
            if (transferAmount < 0) {
                System.out.println("Transfer amount must be positive.");
            } else if (transferAmount > account.getBalance()) {
                System.out.println("Insufficient balance for this transfer.");
            } else {
                account.transfer(transferAmount);
                System.out.printf("Your new balance after transfer is $%.2f%n", account.getBalance());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
    }
}