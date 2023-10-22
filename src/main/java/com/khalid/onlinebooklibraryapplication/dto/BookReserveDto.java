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
public class BookReserveDto {
    private Long reserveId;
    private Long userId;
    private Long bookId;
    private String status;
    private LocalDate reserveDate;
}
