package com.banking;

public class UserFactory {

    public static User getUser(String type, String name, int age, int salary, String email, String streetAddress, String cityStateAddress) {
        if (type.equalsIgnoreCase("saving")) {
            return new User(name, age, salary, Type.SAVING, email, streetAddress, cityStateAddress);
        }
        else if (type.equalsIgnoreCase("current")) {
            return new User(name, age, salary, Type.CURRENT, email, streetAddress, cityStateAddress);
        }
        return null;
    }


}
