package com.rabbitmq.ms.consumer.repository;

import com.rabbitmq.ms.consumer.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory,Long> {
    Inventory findBybookId(Long id);
}
