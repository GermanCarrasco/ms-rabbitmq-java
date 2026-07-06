package com.rabbitmq.ms.consumer.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UpdateStockRequest {
    private Integer totalStock;
    private Integer reservedStock;
}
