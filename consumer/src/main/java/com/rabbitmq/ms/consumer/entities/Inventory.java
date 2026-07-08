package com.rabbitmq.ms.consumer.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private String isbn;
    private String warehouse;
    private Integer totalStock;
    private Integer reservedStock;
    private Integer availableStock;
    private String status;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
