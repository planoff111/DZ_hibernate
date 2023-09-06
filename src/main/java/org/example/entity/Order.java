package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "total_sum")
    private double totalSum;
    @ManyToOne
    private Customer customer;
    @OneToOne(mappedBy = "order")
    OrderDetails details;
    @ManyToMany
    List<Product> products;

    public Order(String name, double totalSum, Customer customer) {
        this.name = name;
        this.totalSum = totalSum;
        this.customer = customer;

    }

}
