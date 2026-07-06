package com.rabbitmq.ms.consumer.client;

import com.rabbitmq.ms.consumer.config.RabbitConfig;
import com.rabbitmq.ms.consumer.entities.Inventory;
import com.rabbitmq.ms.consumer.events.BookCreatedEvent;
import com.rabbitmq.ms.consumer.mapper.IInventoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookConsumer {

    private IInventoryMapper mapper;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(BookCreatedEvent event){

        log.info("Event receive -> book created: {} ",event.toString());

        Inventory inventory = mapper.toInventory(event);
        inventory.setWarehouse("MAIN-WH");
        inventory.setTotalStock(0);
        inventory.setReservedStock(0);
        inventory.setAvailableStock(0);
        inventory.setStatus("AVAILABLE");


    }
}
