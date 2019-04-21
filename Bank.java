package com.banking;

public class Bank implements BankInterface {

    private String name;

    private User user;

    public Bank(String name, User user) {
        this.name = name;
        this.user = user;
    }


    public synchronized void withdraw(int amount) {
        if (user.isAccountExist()) {

            int flag = 1;

            while (flag != 0) {

                if (user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    flag = 0;
                    System.out.println(amount + " has been withdrawn from this bank account.");
                    System.out.println("The new balance is " + user.getBalance());
                }
                else {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
//        else {
//            System.out.println("You don't have an account yet");
//        }
    }


    public synchronized void deposit(int amount) {
        if (user.isAccountExist()) {
            user.setBalance(user.getBalance() + amount);
            System.out.println(amount + " has been added to this bank account.");
            System.out.println("The new balance is " + user.getBalance());
            notify();
        }
//        else {
//            System.out.println("You don't have an account yet");
//        }
    }

}
