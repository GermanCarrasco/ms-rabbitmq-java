package com.rabbitmq.ms.consumer.service;


import com.rabbitmq.ms.consumer.entities.Inventory;
import com.rabbitmq.ms.consumer.exceptions.ResourceNotFoundException;
import com.rabbitmq.ms.consumer.repository.IInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {

    private final IInventoryRepository repository;


    @Override
    public Inventory createInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public void updateInventory(Inventory inventory) {

        Inventory exist = repository.findById(inventory.getId())
                .orElseThrow(() -> new ResourceNotFoundException("UpdateInventory","id",inventory.getId()));
        exist.setStatus(inventory.getStatus());

        exist.setReservedStock(inventory.getReservedStock());
        exist.setAvailableStock(inventory.getAvailableStock());
        exist.setWarehouse(inventory.getWarehouse());
        exist.setTotalStock(inventory.getTotalStock());
        exist.setIsbn(inventory.getIsbn());
        exist.setStatus(inventory.getStatus());

        repository.save(exist);
    }

    @Override
    public Inventory findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FindById","id",id));
    }

    @Override
    public Inventory findByBookId(Long id) {
        return null;
    }

    @Override
    public void deleteInventoryByBookId(Long bookId) {

    }
}
