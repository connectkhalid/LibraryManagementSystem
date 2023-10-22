package com.khalid.onlinebooklibraryapplication.exception;

public class BookAlreadyExistsException extends Exception{
    public BookAlreadyExistsException(String MESSAGE) {
        super(MESSAGE);
    }
}
