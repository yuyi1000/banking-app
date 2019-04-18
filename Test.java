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
            System.out.print("Input your street address: ");
            streetAddress = sc.next();



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

        catch (InputMismatchException e) {
            System.out.println("Caught an Input mismatch exception.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // If the user requirement does not hold, then withdraw and deposit function should not be
        // executed.


//        User user = new User("John", 30, 30000000, Type.CURRENT);


    }

}
