package exceptionLesson;

import exceptionLesson.exceptions.DomainException;

public class Account {
    private final int number;
    private final String holder;
    private double initialBalance;
    private final double withdrawLimit;

    public Account(int number, String holder, double initialBalance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.initialBalance = initialBalance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void withdraw(double amount) throws DomainException {
        this.validateWithdraw(amount);

        this.setInitialBalance(
                this.initialBalance -= amount
        );
    }

    public void validateWithdraw(double amount) throws DomainException {
        if (amount > this.getInitialBalance()) {
            throw new DomainException("Withdraw amount bigger than balance!!!");
        }

        if (amount > this.getWithdrawLimit()) {
            throw new DomainException("Withdraw amount bigger than limit!!!");
        }
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", initialBalance=" + initialBalance +
                ", withdrawLimit=" + withdrawLimit +
                '}';
    }
}
