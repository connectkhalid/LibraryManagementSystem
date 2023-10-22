package com.khalid.onlinebooklibraryapplication.service;

import com.khalid.onlinebooklibraryapplication.dto.BookBorrowingDto;
import com.khalid.onlinebooklibraryapplication.dto.BookBorrowingInfoDto;
import com.khalid.onlinebooklibraryapplication.entity.BookEntity;

import java.util.List;

public interface BookBorrowingService {
    public BookBorrowingDto bookBorrowing(Long bookId) throws Exception;
    public BookBorrowingDto bookReturning(Long bookId) throws Exception;

    public List<BookEntity> getAllBookByUser(Long userId) throws Exception;

    public List<BookBorrowingInfoDto> getUserAllHistory(Long userId) throws Exception;

}
