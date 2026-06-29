package com.rabbitmq.ms.producer.dtos;


import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateBookRequest {
    private String title;
    private String description;
    private String author;
    private String publisher;
    private Integer publicationYear;
    private String language;
    private String category;
    private BigDecimal price;
}
