package com.rabbitmq.ms.consumer.mapper;

import com.rabbitmq.ms.consumer.dtos.InventoryResponse;
import com.rabbitmq.ms.consumer.entities.Inventory;
import com.rabbitmq.ms.consumer.events.BookCreatedEvent;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface IInventoryMapper {
    InventoryResponse toInventoryResponse(Inventory inventory);
    Inventory toInventory(BookCreatedEvent event);
}
