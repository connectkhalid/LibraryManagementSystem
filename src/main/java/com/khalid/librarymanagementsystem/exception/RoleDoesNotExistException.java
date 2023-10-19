package com.khalid.librarymanagementsystem.exception;

public class RoleDoesNotExistException extends RuntimeException{
    public RoleDoesNotExistException(String message){
        super(message);
    }
}
