package com.rabbitmq.ms.consumer.service;

import com.rabbitmq.ms.consumer.entities.Inventory;

public interface IInventoryService {
    Inventory createInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
    Inventory findById(Long id);
    Inventory findByBookId(Long id);
    void deleteInventoryByBookId(Long bookId);
}
