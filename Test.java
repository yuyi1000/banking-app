package com.banking;

public class Test {


    public static void main(String[] args) {
        User user = new User("John", 20, 30000, Type.SAVING);
//        User user = new User("John", 20, 10000, Type.SAVING);

        // If the user requirement does not hold, then withdraw and deposit function should not be
        // executed.


//        User user = new User("John", 30, 30000000, Type.CURRENT);
        Bank bank = new Bank("Chase", user);
        bank.deposit(100);
        bank.withdraw(50);
        bank.withdraw(60);
        bank.withdraw(30);

    }

}
