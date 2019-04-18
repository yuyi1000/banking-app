package com.banking;

public class Test {


    public static void main(String[] args) {

        try {
//            User user = new User("John", 20, 30000, Type.CURRENT, "a@b.com");
            User user = new User("John", 20, 30000, Type.SAVING, "a@b.com");
//            User user = new User("John", 10, 30000, Type.SAVING, "c@d.com");
//            User user = new User("John", 10, 30000, Type.SAVING, "c.com");
//            User user = new User("John", 20, 10000, Type.SAVING, "hi");

//            User user = new User("John", 20, 10000, Type.SAVING, "hi.@.hi");

            Bank bank = new Bank("Chase", user);
            bank.deposit(100);
            bank.withdraw(50);
            bank.withdraw(60);
            bank.withdraw(30);


        }
        catch (InvalidAgeException e) {
            System.out.println("Caught an Invalid age exception.");
            e.printStackTrace();
        }

        catch (InvalidBalanceException e) {
            System.out.println("Caught an Invalid balance exception.");
            e.printStackTrace();
//            System.out.println(e);
        }



        // If the user requirement does not hold, then withdraw and deposit function should not be
        // executed.


//        User user = new User("John", 30, 30000000, Type.CURRENT);


    }

}
