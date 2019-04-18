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
            if (user.getTotal() < amount) {
//                System.out.println("Not enough money left.");
                throw new InvalidBalanceException("Not enough money left.");
            }
            else {
                user.setTotal(user.getTotal() - amount);
                System.out.println("The new total is " + user.getTotal());
            }
        }
//        else {
//            System.out.println("You don't have an account yet");
//        }
    }


    public void deposit(int amount) {
        if (user.isAccountExist()) {
            user.setTotal(user.getTotal() + amount);
            System.out.println("The new total is " + user.getTotal());
        }
//        else {
//            System.out.println("You don't have an account yet");
//        }
    }

}
