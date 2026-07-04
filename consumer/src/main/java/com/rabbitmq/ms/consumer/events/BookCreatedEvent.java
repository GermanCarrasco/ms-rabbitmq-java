package com.rabbitmq.ms.consumer.events;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreatedEvent {
    private Long bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer publicationYear;
    private String language;
    private String category;
    private BigDecimal price;
    private LocalDateTime createdAt;
}
