package com.banking;

public class InvalidEmailException extends RuntimeException {

    InvalidEmailException(String s) {
        System.out.print(s);
    }
}
