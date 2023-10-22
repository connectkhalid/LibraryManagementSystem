package com.khalid.onlinebooklibraryapplication.repository;

import com.khalid.onlinebooklibraryapplication.entity.BookBorrowingEntity;
import com.khalid.onlinebooklibraryapplication.entity.BookEntity;
import com.khalid.onlinebooklibraryapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookBorrowRepository extends JpaRepository<BookBorrowingEntity, Long> {

    BookBorrowingEntity findByUserEntityAndBookEntityAndReturnDateIsNull(UserEntity userEntity, BookEntity bookEntity);


    List<BookBorrowingEntity> findAllByUserEntity(UserEntity userEntity);

    List<BookBorrowingEntity> findAllByUserEntityAndReturnDateIsNull(UserEntity userEntity);
}
