package com.rabbitmq.ms.producer.dtos;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp,
                            int status,
                            String error,
                            String message) {
}
