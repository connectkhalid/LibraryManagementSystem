package com.khalid.onlinebooklibraryapplication.repository;

import com.khalid.onlinebooklibraryapplication.entity.BookEntity;
import com.khalid.onlinebooklibraryapplication.entity.BookReviewEntity;
import com.khalid.onlinebooklibraryapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReviewEntity, Long> {

    List<BookReviewEntity> findAllByBookEntity(BookEntity bookEntity) throws Exception;


    BookReviewEntity findByUserEntityAndBookEntity(UserEntity userEntity, BookEntity bookEntity);

    BookReviewEntity findByReviewIdAndBookEntityAndUserEntity(Long reviewId, BookEntity bookEntity, UserEntity userEntity);
}
