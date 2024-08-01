package com.jotacode.restfullapi.error;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
