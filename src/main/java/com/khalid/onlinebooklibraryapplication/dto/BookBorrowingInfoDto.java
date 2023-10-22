package com.khalid.onlinebooklibraryapplication.dto;

import com.khalid.onlinebooklibraryapplication.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookBorrowingInfoDto {

    private Long borrowId;
    private BookEntity bookEntity;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;


}

