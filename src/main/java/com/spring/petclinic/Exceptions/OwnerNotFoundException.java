package com.spring.petclinic.Exceptions;
public class OwnerNotFoundException extends RuntimeException{
    public OwnerNotFoundException(String message){
        System.out.println("Owner not found..");
    }
}
