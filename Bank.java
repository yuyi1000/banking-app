package com.banking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank implements BankInterface {

    private String name;

//    private User user;

    private List<User> users;


    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void sortUsers() {
        Collections.sort(this.users);
    }

    public synchronized void withdraw(int amount, User user) {
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


    public synchronized void deposit(int amount, User user) {
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
