package com.rabbitmq.ms.producer.service;

import com.rabbitmq.ms.producer.dtos.BookResponse;
import com.rabbitmq.ms.producer.dtos.CreateBookRequest;
import com.rabbitmq.ms.producer.dtos.UpdateBookRequest;
import com.rabbitmq.ms.producer.entities.Book;

import java.util.Optional;

public interface IBookService {
    Book registerBook(CreateBookRequest book);
    void updateBook(Long id,UpdateBookRequest book);
    Optional<BookResponse> findBook(Long bookId);
    void deleteBook(Long bookId);
}
