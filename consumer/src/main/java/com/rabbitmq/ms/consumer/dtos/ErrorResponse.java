package com.rabbitmq.ms.consumer.dtos;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp,
                            int status,
                            String error,
                            String message) {
}
