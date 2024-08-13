package com.jotacode.restfullapi.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @NotNull(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Price is mandatory")
    private Double price;




}
