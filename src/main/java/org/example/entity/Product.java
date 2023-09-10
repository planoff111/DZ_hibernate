package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private double quantity;
    @ManyToMany
    private List<Order> order;

    public Product(String name, double price, double quantity, List<Order> order) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
    }
}
