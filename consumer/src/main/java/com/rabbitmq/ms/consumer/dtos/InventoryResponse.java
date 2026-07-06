package com.rabbitmq.ms.consumer.dtos;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
    private Long id;
    private Long bookId;
    private String isbn;
    private String warehouse;
    private Integer totalStock;
    private Integer reservedStock;
    private Integer availableStock;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
