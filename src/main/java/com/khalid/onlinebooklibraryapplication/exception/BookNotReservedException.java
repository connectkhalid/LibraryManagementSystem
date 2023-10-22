package com.khalid.onlinebooklibraryapplication.exception;

public class BookNotReservedException extends Exception{
    public BookNotReservedException(String MESSAGE) {
        super(MESSAGE);
    }
}
