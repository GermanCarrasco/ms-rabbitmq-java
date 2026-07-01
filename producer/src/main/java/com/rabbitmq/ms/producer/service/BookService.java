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
    public Book registerBook(CreateBookRequest book) {
        return repository.save(mapper.toEntity(book));
    }

    @Override
    public void updateBook(Long id, UpdateBookRequest book) {

        Book bookDb = repository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Book","id",id)
        );

        bookDb.setAuthor(book.getAuthor());
        bookDb.setCategory(book.getCategory());
        bookDb.setIsbn(bookDb.getIsbn());
        bookDb.setDescription(book.getDescription());
        bookDb.setLanguage(book.getLanguage());
        bookDb.setPrice(book.getPrice());
        bookDb.setPublicationYear(book.getPublicationYear());
        bookDb.setPublisher(book.getPublisher());
        bookDb.setTitle(bookDb.getTitle());

        repository.save(bookDb);
    }

    @Override
    public Optional<BookResponse> findBook(Long bookId) {
        return Optional.ofNullable(mapper.toResponse(repository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "id", bookId))));
    }

    @Override
    public void deleteBook(Long bookId) {

        Book exist = repository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book","id",bookId)
        );

        repository.delete(exist);
    }
}
