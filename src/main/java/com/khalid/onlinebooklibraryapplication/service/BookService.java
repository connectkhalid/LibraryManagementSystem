package com.khalid.onlinebooklibraryapplication.service;

import com.khalid.onlinebooklibraryapplication.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto) throws Exception;
    BookDto updateBook(BookDto bookDto) throws Exception;
    void deleteBook(BookDto bookDto) throws Exception;
     List<BookDto> getAllBook();


}
