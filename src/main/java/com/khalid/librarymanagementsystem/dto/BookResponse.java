package com.khalid.librarymanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
    private Long bookId;
    private String title,authorName,genre,description;
    private Double price;

    public BookResponse(Long bookId, String title, String authorName,
                        String genre, Double price,String description) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.description = description;
        this.price = price;
    }
}
