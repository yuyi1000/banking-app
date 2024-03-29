package com.banking;

public class BankCustomer extends Thread {

    Bank bank;
    int amount;

    User user;

    boolean isDeposit;

    public BankCustomer(Bank bank, int amount, boolean isDeposit) {
        this.bank = bank;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            bank.deposit(amount, user);
        }
        else {
            bank.withdraw(amount, user);
        }
    }

}
