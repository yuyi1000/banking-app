package com.banking;

// TODO: If any info is not correct, not create that user.

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements UserInterface, Serializable {

    private String name;
    private int age;
    private int salary;

    private Type type;



    private int balance;

    private boolean accountExist;

    private String email;

    private String streetAddress;

    private String cityStateAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isAccountExist() {
        return accountExist;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCityStateAddress() {
        return cityStateAddress;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", type=" + type +
                ", balance=" + balance +
                ", accountExist=" + accountExist +
                ", email='" + email + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", cityStateAddress='" + cityStateAddress + '\'' +
                '}';
    }

    public User(String name, int age, int salary, Type type, String email, String streetAddress, String cityStateAddress) throws InvalidAgeException {

        if (type == Type.SAVING && age < 18) {
            throw new InvalidAgeException("To open a saving account, age should be greater than 18");
        }

        if (type == Type.CURRENT && age < 25) {
            throw new InvalidAgeException("To open a current account, age should be greater than 25.");
        }

        // do something with email validation.

        // my solution.
//        Pattern p = Pattern.compile(".+@.+");

        // modified from https://howtodoinjava.com/regex/java-regex-validate-email-address/
        Pattern p = Pattern.compile("[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+");


        Matcher m = p.matcher(email);

        if (!m.matches()) {
//            System.out.println("Not a valid email address.");
//            return;
            throw new InvalidEmailException("Not a valid email address");

        }


        this.name = name;
        this.age = age;
        this.salary = salary;
        this.type = type;
        this.email = email;
        this.streetAddress = streetAddress;
        this.cityStateAddress = cityStateAddress;

        if (hasAccount()) {
            this.accountExist = true;
        }
        else {
            this.accountExist = false;
        }

    }

    public boolean hasAccount() {


        switch (type) {
            case SAVING:
                if (salary >= 20000 && salary <= 50000) {
                    return true;
                }
            case CURRENT:
                if (salary >= 1000000) {
                    return true;
                }
        }
        System.out.println("You don't meet requirement for salary.");
        return false;


//        if (type == "saving") {
//            if (age >= 18 && 20000 <= salary && salary <= 50000) {
//                return true;
//            }
//        }
//        else if (type == "current") {
//            if (age >= 25 && salary >= 1000000) {
//                return true;
//            }
//        }
//        return false;
    }



}
