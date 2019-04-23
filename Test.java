package com.banking;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {


    public static void main(String[] args) {


        String name;
        int age;
        int salary;
        String t;
        String email;
        String streetAddress;
        String cityStateAddress;


        Type type;

        String choice;
        boolean isDeposit;
        int amount;
        String moreTransaction;

        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Input your city and state address: ");
            cityStateAddress = sc.nextLine();
            System.out.print("Input your name: ");
            name = sc.next();
            System.out.print("Input your age: ");
            age = sc.nextInt();
            System.out.print("Input your salary: ");
            salary = sc.nextInt();
            System.out.print("Input your type SAVING or CURRENT: ");
            t = sc.next();
            System.out.print("Input your email: ");
            email = sc.next();
            sc.nextLine();
            System.out.print("Input your street address: ");
            streetAddress = sc.nextLine();
//            sc.close();



            if (t.equals("SAVING")) {
                type = Type.SAVING;
            }
            else if (t.equals("CURRENT")) {
                type = Type.CURRENT;
            }
            else {
                System.err.println("Wrong input type.");
                return;
            }

            User user = new User(name, age, salary, type, email, streetAddress, cityStateAddress);

//            User user = new User("John", 20, 30000, Type.CURRENT, "a@b.com");
//            User user = new User("John", 20, 30000, Type.SAVING, "a@b.com");
//            User user = new User("John", 10, 30000, Type.SAVING, "c@d.com");
//            User user = new User("John", 10, 30000, Type.SAVING, "c.com");
//            User user = new User("John", 20, 10000, Type.SAVING, "hi");

//            User user = new User("John", 20, 10000, Type.SAVING, "hi.@.hi");


            StringTokenizer st = new StringTokenizer(cityStateAddress, " ,");
            System.out.println("Showing city state zipcode info.");
            while (st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }


            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User u2 = (User) ois.readObject();

            System.out.println(u2);

            Bank bank = new Bank("Chase");


            System.out.println("You have " + user.getBalance() + " left.");


            // TODO: If use a new scanner, it will return a NoSuchElementException, figure out what happened.
//            sc = new Scanner(System.in);


//            while (true) {
//
//                System.out.print("Choose to deposit or withdraw: ");
//                choice = sc.nextLine();
//                if (choice.equalsIgnoreCase("deposit")) {
//                    isDeposit = true;
//                }
//                else if (choice.equalsIgnoreCase("withdraw")) {
//                    isDeposit = false;
//                }
//                else {
//                    System.err.println("not invalid option");
//                    return;
//                }
//
//                System.out.print("Input amount of money: ");
//                amount = sc.nextInt();
//
//                if (isDeposit) {
//                    bank.deposit(amount);
//                }
//                else {
//                    bank.withdraw(amount);
//                }
//
//                System.out.print("Do you need to do more transactions? (type NO if you want to exist): ");
//                sc.nextLine();
//                moreTransaction = sc.nextLine();
//                if (moreTransaction.equalsIgnoreCase("no")) {
//                    break;
//                }
//            }
//
//            sc.close();


            BankCustomer bc1 = new BankCustomer(bank, 200, false);
            BankCustomer bc2 = new BankCustomer(bank, 300, true);

            bc1.start();
            bc2.start();


            bc1.join();
            bc2.join();



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
        catch (InvalidEmailException e) {
            e.printStackTrace();
        }

        catch (InputMismatchException e) {
            System.out.println("Caught an Input mismatch exception.");
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }




        // If the user requirement does not hold, then withdraw and deposit function should not be
        // executed.


//        User user = new User("John", 30, 30000000, Type.CURRENT);


    }

}
