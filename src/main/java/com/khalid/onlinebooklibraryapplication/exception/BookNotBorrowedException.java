package com.khalid.onlinebooklibraryapplication.exception;

public class BookNotBorrowedException extends Exception{
    public BookNotBorrowedException(String MESSAGE) {
        super(MESSAGE);
    }
}
