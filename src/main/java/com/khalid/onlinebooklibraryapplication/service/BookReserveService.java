package com.khalid.onlinebooklibraryapplication.service;

import com.khalid.onlinebooklibraryapplication.dto.BookReserveDto;

public interface BookReserveService {
    public BookReserveDto reserveBook(Long bookId) throws Exception;
    public BookReserveDto cancelReserveBook(Long bookId) throws Exception;
}
