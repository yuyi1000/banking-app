package com.banking;

public interface BankInterface {
    void withdraw(int amount, User user);
    void deposit(int amount, User user);
}
