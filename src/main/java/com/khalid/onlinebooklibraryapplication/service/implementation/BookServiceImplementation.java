package com.khalid.onlinebooklibraryapplication.service.implementation;

import com.khalid.onlinebooklibraryapplication.dto.BookDto;
import com.khalid.onlinebooklibraryapplication.entity.BookEntity;
import com.khalid.onlinebooklibraryapplication.exception.BookAlreadyExistsException;
import com.khalid.onlinebooklibraryapplication.service.BookService;
import com.khalid.onlinebooklibraryapplication.exception.BookIdNotFoundException;
import com.khalid.onlinebooklibraryapplication.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;



    public BookDto createBook(BookDto book) throws BookAlreadyExistsException {
        if(bookRepository.findBookByTitle(book.getTitle()).isPresent())
            throw new BookAlreadyExistsException("Book is already exists! Unable to create");
        ModelMapper modelMapper = new ModelMapper();
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setStatus("AVAILABLE");
        bookEntity.setDeleted(false);

        BookEntity storedBookDetails = bookRepository.save(bookEntity);
        return modelMapper.map(storedBookDetails,BookDto.class);
    }

    public List<BookDto> getAllBook(){

        List<BookEntity> allBooks = bookRepository.findAllByDeletedFalse();

        List<BookDto> bookDtoList = allBooks.stream()
                .map(bookEntity -> BookDto.builder()
                        .bookId(bookEntity.getBookId())
                        .title(bookEntity.getTitle())
                        .author(bookEntity.getAuthor())
                        .status(bookEntity.getStatus())
                        .build()
                )
                .collect(Collectors.toList());


        return bookDtoList;
    }

    public void deleteBook(BookDto bookDto) throws Exception {
        Optional<BookEntity> optionalBook = bookRepository.findByBookIdAndDeletedFalse(bookDto.getBookId());

        if (optionalBook.isPresent()) {
            BookEntity bookEntity = optionalBook.get();
            if(bookEntity.getStatus().equals("BORROWED")) throw new Exception("This book is in borrowed state, you should not delete it!");
            bookEntity.setDeleted(true);
            bookRepository.save(bookEntity);
        } else {
            throw new Exception("Book does not exists!");
        }
    }

    public BookDto updateBook(BookDto book) throws BookIdNotFoundException {

        ModelMapper modelMapper = new ModelMapper();
        BookEntity bookEntity = bookRepository.findByBookId(book.getBookId());

        if (bookEntity == null || bookEntity.isDeleted())  throw new BookIdNotFoundException("Book does not exists!");;

        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        BookEntity storedBookDetails = bookRepository.save(bookEntity);
        return modelMapper.map(storedBookDetails,BookDto.class);
    }



}
