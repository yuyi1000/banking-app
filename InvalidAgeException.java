package com.banking;

public class InvalidAgeException extends RuntimeException {

    InvalidAgeException(String s) {
        System.out.println(s);
    }

}
