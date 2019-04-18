package com.banking;

public class InvalidBalanceException extends RuntimeException {

    InvalidBalanceException(String s) {
        System.out.println(s);
    }

}
