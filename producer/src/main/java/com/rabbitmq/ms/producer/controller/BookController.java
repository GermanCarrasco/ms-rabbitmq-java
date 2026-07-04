package com.rabbitmq.ms.producer.controller;

import com.rabbitmq.ms.producer.dtos.BookResponse;
import com.rabbitmq.ms.producer.dtos.CreateBookRequest;
import com.rabbitmq.ms.producer.dtos.UpdateBookRequest;
import com.rabbitmq.ms.producer.entities.Book;
import com.rabbitmq.ms.producer.mapper.IBookMapper;
import com.rabbitmq.ms.producer.service.BookService;
import com.rabbitmq.ms.producer.service.RabbitMqPublishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;
    private final RabbitMqPublishService rabbitMqService;
    private final IBookMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@Valid @RequestBody CreateBookRequest book){

        Book bookCreated = bookService.registerBook(book);

        if(bookCreated == null){
            log.error("An error occurred while creating the book.");
            return ResponseEntity.status(500).body("An error occurred while creating the book.");
        }

        log.info("The book was created: {} ",bookCreated.getTitle());

        rabbitMqService.publishBook(mapper.toCreatedEvent(bookCreated));

        return ResponseEntity.status(200).body(mapper.toResponse(bookCreated));

    }
    
    @GetMapping("/findBook")
    public Optional<BookResponse> findBookById(@RequestParam("id") Long id){
        return bookService.findBook(id);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestParam("id") Long id, @RequestBody UpdateBookRequest request){
        bookService.updateBook(id,request);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("deleteBook")
    public ResponseEntity<?> deleteBook(@RequestParam("id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.status(204).build();
    }

}
