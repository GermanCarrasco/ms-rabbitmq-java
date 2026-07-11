package com.rabbitmq.ms.consumer.client;

import com.rabbitmq.ms.consumer.config.RabbitConfig;
import com.rabbitmq.ms.consumer.entities.Inventory;
import com.rabbitmq.ms.consumer.events.BookCreatedEvent;
import com.rabbitmq.ms.consumer.mapper.IInventoryMapper;
import com.rabbitmq.ms.consumer.service.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookConsumer {

    private final  IInventoryMapper mapper;
    private final InventoryServiceImpl service;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(BookCreatedEvent event){

        /****
         * <h1>Its creation the registry of inventory for a book.</h1>
         * <p>
         *     OUT_OF_STOCK → availableStock = 0
         *     LOW_STOCK → availableStock > 0 pero por debate de un umbral
         *     AVAILABLE → stock sufficient
         * </p>
         * ***/
        log.info("Event receive -> book created: {} ",event.toString());

        Inventory inventory = mapper.toInventory(event);
        inventory.setWarehouse("MAIN-WH");
        inventory.setTotalStock(0);
        inventory.setReservedStock(0);
        inventory.setAvailableStock(0);
        inventory.setStatus("OUT_OF_STOCK");

        Inventory saved = service.createInventory(inventory);

        log.info("Inventory added: {}",saved.getId());

    }
}
