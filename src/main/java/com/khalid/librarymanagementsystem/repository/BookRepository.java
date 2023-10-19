package com.khalid.librarymanagementsystem.repository;
import com.khalid.librarymanagementsystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    Optional<BookEntity> findByTitleAndAuthorName(String title, String authorName);

    List<BookEntity> findAllByAuthorName(String authorName);
}
