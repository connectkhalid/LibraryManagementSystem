package com.khalid.librarymanagementsystem.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotEmpty(message = "title is required")
    private String title;
    @NotEmpty(message = "authorName is required")
    private String authorName;
    @NotEmpty(message = "genre is required")
    private String genre;
    @NotEmpty(message = "description is required")
    private String description;
    @NotNull(message = "price is required")
    private Double price;
}