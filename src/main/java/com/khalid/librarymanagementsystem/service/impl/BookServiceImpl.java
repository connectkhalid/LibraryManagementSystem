package com.khalid.librarymanagementsystem.service.impl;

import com.khalid.librarymanagementsystem.dto.BookRequest;
import com.khalid.librarymanagementsystem.dto.BookResponse;
import com.khalid.librarymanagementsystem.entity.BookEntity;
import com.khalid.librarymanagementsystem.exception.BookAlreadyExistException;
import com.khalid.librarymanagementsystem.exception.BookNotFoundException;
import com.khalid.librarymanagementsystem.repository.BookRepository;
import com.khalid.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.khalid.librarymanagementsystem.values.Messages.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<BookResponse> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        bookEntities.forEach(bookEntity -> bookResponses.add(
                makeBookResponse(bookEntity)
        ));
        return bookResponses;

    }

    @Override
    public BookResponse getBookByBookId(String bookId) {
        var book = bookRepository.findById(Long.parseLong(bookId));
        if(book.isEmpty()){
            throw new BookNotFoundException(NO_BOOK_WITH_ID);
        }
        BookEntity bookEntity = book.get();
        return makeBookResponse(bookEntity);
    }

    @Override
    public BookResponse getBookByAuthorNameAndBookTitle(String authorName, String bookTitle) {
        var book = bookRepository.findByTitleAndAuthorName(bookTitle,authorName);
        if(book.isEmpty()){
            throw new BookNotFoundException(NO_BOOK_WITH_TITLE_AUTHOR);
        }
        BookEntity bookEntity = book.get();
        return makeBookResponse(bookEntity);
    }

    @Override
    public List<BookResponse> getAllBooksByAuthorName(String authorName) {
        List<BookEntity> bookEntities = bookRepository.findAllByAuthorName(authorName);
        List<BookResponse> bookResponses = new ArrayList<>();
        bookEntities.forEach(bookEntity -> bookResponses.add(
                makeBookResponse(bookEntity)
        ));
        return bookResponses;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        if(bookRepository.findByTitleAndAuthorName(bookRequest.getTitle(),bookRequest.getAuthorName()).isPresent()){
            throw new BookAlreadyExistException(BOOK_EXIST_WITH_TITLE_AUTHOR);
        }
        BookEntity bookEntity =bookRepository.save(BookEntity.builder()
                .authorName(bookRequest.getAuthorName())
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .genre(bookRequest.getGenre())
                .description(bookRequest.getDescription())
                .build());
        return makeBookResponse(bookEntity);
    }
    @Override
    public BookResponse updateBookById(Long bookId, BookRequest bookRequest) {
        var book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw new BookNotFoundException(NO_BOOK_WITH_ID);
        }
        BookEntity bookEntity = book.get();
        bookEntity.setAuthorName(bookRequest.getAuthorName());
        bookEntity.setDescription(bookRequest.getDescription());
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setGenre(bookRequest.getGenre());
        bookEntity.setPrice(bookRequest.getPrice());

        BookEntity updatedBook = bookRepository.save(bookEntity);
        return makeBookResponse(updatedBook);
    }

    @Override
    public String deleteBookById(Long bookId) {
        var book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw  new BookNotFoundException(NO_BOOK_WITH_ID);
        }
        bookRepository.deleteById(bookId);
        return BOOK_DELETED;
    }
    public BookResponse makeBookResponse(BookEntity bookEntity){
        return new BookResponse(bookEntity.getBookId(),
                bookEntity.getTitle(),
                bookEntity.getAuthorName(),
                bookEntity.getGenre(),
                bookEntity.getPrice(),
                bookEntity.getDescription());
    }
}
