package com.khalid.onlinebooklibraryapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookReviewDto {

    private Long reviewId;
    private Long bookId;
    private Long userId;
    private Long rating;
    private String review;
    private LocalDate date;


}
