package com.rabbitmq.ms.producer.controller;

import com.rabbitmq.ms.producer.dtos.CreateBookRequest;
import com.rabbitmq.ms.producer.entities.Book;
import com.rabbitmq.ms.producer.mapper.IBookMapper;
import com.rabbitmq.ms.producer.service.BookService;
import com.rabbitmq.ms.producer.service.RabbitMqPublishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;
    private final RabbitMqPublishService rabbitMqService;
    private final IBookMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody CreateBookRequest book){

        Book bookCreated = bookService.registerBook(book);

        if(bookCreated == null){
            log.error("An error occurred while creating the book.");
            return ResponseEntity.status(500).body("An error occurred while creating the book.");
        }

        log.info("The book was created: {} ",bookCreated.getTitle());

        rabbitMqService.publishBook(mapper.toCreatedEvent(bookCreated));

        return ResponseEntity.status(200).body(mapper.toResponse(bookCreated));

    }

}
