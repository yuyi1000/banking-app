package com.banking;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {

        Bank bank = new Bank("Chase");

//        User u1 = new User("John", 20, 30000, Type.SAVING, "a@b", "first st", "athens, oh");
//        User u2 = new User("Jake", 30, 50000, Type.SAVING, "a@b", "first st", "athens, oh");
//        User u3 = new User("Tina", 40, 30000, Type.SAVING, "a@b", "first st", "athens, oh");
//        User u4 = new User("Philips", 50, 50000, Type.SAVING, "a@b", "first st", "athens, oh");


        User u1 = UserFactory.getUser("saving", "John", 20, 30000, "a@b", "first st", "athens, oh");
        User u2 = UserFactory.getUser("saving", "John", 30, 50000, "a@b", "first st", "athens, oh");
        User u3 = UserFactory.getUser("saving", "John", 40, 30000, "a@b", "first st", "athens, oh");
        User u4 = UserFactory.getUser("saving", "John", 50, 50000, "a@b", "first st", "athens, oh");
        





        bank.addUser(u3);
        bank.addUser(u1);
        bank.addUser(u4);
        bank.addUser(u2);

        List<User> users = bank.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("After sort");

        bank.sortUsers();
        users = bank.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }

}
