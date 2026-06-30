package com.rabbitmq.ms.producer.service;

import com.rabbitmq.ms.producer.dtos.BookResponse;
import com.rabbitmq.ms.producer.dtos.CreateBookRequest;
import com.rabbitmq.ms.producer.dtos.UpdateBookRequest;
import com.rabbitmq.ms.producer.entities.Book;
import com.rabbitmq.ms.producer.exceptions.ResourceNotFoundException;
import com.rabbitmq.ms.producer.mapper.IBookMapper;
import com.rabbitmq.ms.producer.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{

    private final IBookRepository repository;
    private final IBookMapper mapper;


    @Override
    public BookResponse registerBook(CreateBookRequest book) {
        Book bookDb = repository.save(mapper.toEntity(book));
        return mapper.toResponse(bookDb);
    }

    @Override
    public void updateBook(Long id, UpdateBookRequest book) {
        Book bookDb = repository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Book","id",id)
        );
    }

    @Override
    public Optional<BookResponse> findBook(Long bookId) {
        return Optional.empty();
    }

    @Override
    public void deleteBook(Long bookId) {

    }
}
