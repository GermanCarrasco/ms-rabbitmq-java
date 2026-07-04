package com.rabbitmq.ms.producer.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    @NotBlank(message = "ISBN is required")
    @Size(min = 15, max = 25, message = "ISBN must be between 15 and 20 characters")
    private String isbn;
    @NotBlank(message = "Title is required")
    @Size(max = 50)
    private String title;
    @NotBlank(message = "The Description is required")
    @Size(max = 100)
    private String description;
    @NotBlank(message = "Author is required")
    private String author;
    @NotBlank(message = "Publisher is required")
    private String publisher;
    @NotNull
    private Integer publicationYear;
    @NotBlank(message = "Language is required")
    private String language;
    @NotBlank(message = "Category is required")
    private String category;
    @NotNull
    @DecimalMin(value="0.01", message = "Price must be greater than zero")
    private BigDecimal price;
}
