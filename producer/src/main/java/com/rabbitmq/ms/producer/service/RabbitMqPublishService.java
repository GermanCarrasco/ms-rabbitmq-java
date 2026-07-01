package com.rabbitmq.ms.producer.service;

import com.rabbitmq.ms.producer.configs.RabbitConfig;
import com.rabbitmq.ms.producer.events.BookCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitMqPublishService {

    private final RabbitTemplate template;

    public void publishBook(BookCreatedEvent event){

        template
                .convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                event
        );

        log.info("BookCreatedEvent : {} ", event.toString());
    }
}
