package exceptionLesson;

import exceptionLesson.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data:");

        System.out.print("Number:");
        int number = sc.nextInt();

        System.out.print("Holder:");
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.print("Initial balance:");
        double initialBalance = sc.nextDouble();

        System.out.print("Withdraw limit:");
        double withdrawLimit = sc.nextDouble();

        System.out.print("Enter amount to withdraw:");
        double withdraw = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);
        try {
            account.withdraw(withdraw);
            System.out.println("New balance: " + account.getInitialBalance());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}