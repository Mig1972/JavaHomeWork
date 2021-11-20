package com.pb.mospan.hw8;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(String message) {
        super(message);
       // System.out.println(message);
    }

    public WrongPasswordException() {}
}
