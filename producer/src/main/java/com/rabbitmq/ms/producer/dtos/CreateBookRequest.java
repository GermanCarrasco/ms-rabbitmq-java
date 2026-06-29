package com.rabbitmq.ms.producer.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    private String isbn;
    private String title;
    private String description;
    private String author;
    private String publisher;
    private Integer publicationYear;
    private String language;
    private String category;
    private BigDecimal price;
}
