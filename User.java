package com.banking;



public class User implements UserInterface {

    private String name;
    private int age;
    private int salary;

    private Type type;

    private int total;

    private boolean accountExist;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isAccountExist() {
        return accountExist;
    }

    public User(String name, int age, int salary, Type type) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.type = type;

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
                if (age >= 18 && salary >= 20000 && salary <= 50000) {
                    return true;
                }
            case CURRENT:
                if (age >= 25 && salary >= 1000000) {
                    return true;
                }
        }
        System.out.println("You don't meet requirement.");
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
