package com.rabbitmq.ms.producer.repository;

import com.rabbitmq.ms.producer.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
