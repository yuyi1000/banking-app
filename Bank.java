package com.banking;

public class Bank implements BankInterface {

    private String name;

    private User user;

    public Bank(String name, User user) {
        this.name = name;
        this.user = user;
    }


    public void withdraw(int amount) throws InvalidBalanceException {
        if (user.isAccountExist()) {
            if (user.getBalance() < amount) {
//                System.out.println("Not enough money left.");
                throw new InvalidBalanceException("Not enough money left.");
            }
            else {
                user.setBalance(user.getBalance() - amount);
                System.out.println("The new total is " + user.getBalance());
            }
        }
//        else {
//            System.out.println("You don't have an account yet");
//        }
    }


    public void deposit(int amount) {
        if (user.isAccountExist()) {
            user.setBalance(user.getBalance() + amount);
            System.out.println("The new total is " + user.getBalance());
        }
//        else {
//            System.out.println("You don't have an account yet");
//        }
    }

}
