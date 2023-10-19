package com.khalid.librarymanagementsystem.service;

import com.khalid.librarymanagementsystem.dto.BookRequest;
import com.khalid.librarymanagementsystem.dto.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAllBooks();
    public BookResponse getBookByBookId(String bookId);
    public BookResponse getBookByAuthorNameAndBookTitle(String authorName,String bookTitle);

    public List<BookResponse> getAllBooksByAuthorName(String authorName);

    public BookResponse createBook(BookRequest bookRequest);
    public BookResponse updateBookById(Long bookId,BookRequest bookRequest);
    public String deleteBookById(Long bookId);

}
