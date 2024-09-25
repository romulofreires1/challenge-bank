package br.com.example.challengebank;

import br.com.example.challengebank.model.Account;
import br.com.example.challengebank.model.MenuOption;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

interface AccountStrategy {
    void execute(Scanner scanner, Account account);
}

class CheckBalanceStrategy implements AccountStrategy {
    @Override
    public void execute(Scanner scanner, Account account) {
        System.out.printf("Your current balance is $%.2f%n", account.getBalance());
    }
}

class DepositStrategy implements AccountStrategy {
    @Override
    public void execute(Scanner scanner, Account account) {
        System.out.println("Enter the amount to deposit:");
        try {
            double amountReceived = scanner.nextDouble();
            if (amountReceived <= 0) {
                System.out.println("Deposit amount must be positive.\n");
            } else {
                account.deposit(amountReceived);
                System.out.printf("Your new balance after deposit is $%.2f%n", account.getBalance());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.\n");
            scanner.next();
        }
    }
}

class TransferStrategy implements AccountStrategy {
    @Override
    public void execute(Scanner scanner, Account account) {
        System.out.println("Enter the amount to transfer:");
        try {
            double transferAmount = scanner.nextDouble();
            if (transferAmount <= 0) {
                System.out.println("Transfer amount must be positive.");
            } else if (transferAmount > account.getBalance()) {
                System.out.println("Insufficient balance for this transfer.");
            } else {
                account.transfer(transferAmount);
                System.out.printf("Your new balance after transfer is $%.2f%n", account.getBalance());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }
}

public class SeniorDeveloper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Peter Parker", "Checking", 1500.00);
        Map<MenuOption, AccountStrategy> strategyMap = initializeStrategyMap();

        displayAccountInfo(account);
        runMenuLoop(scanner, account, strategyMap);

        scanner.close();
    }

    private static Map<MenuOption, AccountStrategy> initializeStrategyMap() {
        Map<MenuOption, AccountStrategy> strategyMap = new HashMap<>();
        strategyMap.put(MenuOption.CHECK_BALANCE, new CheckBalanceStrategy());
        strategyMap.put(MenuOption.DEPOSIT, new DepositStrategy());
        strategyMap.put(MenuOption.TRANSFER, new TransferStrategy());
        return strategyMap;
    }

    private static void runMenuLoop(Scanner scanner, Account account, Map<MenuOption, AccountStrategy> strategyMap) {
        while (true) {
            MenuOption option = displayMenu(scanner);
            if (option == MenuOption.EXIT) {
                System.out.println("Thank you! Exiting the program.");
                return;
            }

            AccountStrategy strategy = strategyMap.get(option);
            if (strategy != null) {
                strategy.execute(scanner, account);
            } else {
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
            int input = scanner.nextInt();
            return MenuOption.fromValue(input);
        } catch (InputMismatchException e) {
            System.out.println("Input error.");
            scanner.next();
            return null;
        }
    }
}