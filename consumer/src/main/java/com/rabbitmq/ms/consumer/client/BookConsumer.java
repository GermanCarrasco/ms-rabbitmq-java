package com.rabbitmq.ms.consumer.client;

import com.rabbitmq.ms.consumer.config.RabbitConfig;
import com.rabbitmq.ms.consumer.events.BookCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(BookCreatedEvent event){
        log.info("Event receive -> book created: {} ",event.toString());
    }
}
