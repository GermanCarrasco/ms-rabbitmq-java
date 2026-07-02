package com.rabbitmq.ms.producer.mapper;

import com.rabbitmq.ms.producer.dtos.BookResponse;
import com.rabbitmq.ms.producer.dtos.CreateBookRequest;
import com.rabbitmq.ms.producer.entities.Book;
import com.rabbitmq.ms.producer.events.BookCreatedEvent;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper(componentModel = "spring")
public interface IBookMapper {
    Book toEntity(CreateBookRequest request);
    BookResponse toResponse(Book book);
    BookCreatedEvent toCreatedEvent(Book book);
    List<BookResponse> toResponseList(List<Book> books);
}
