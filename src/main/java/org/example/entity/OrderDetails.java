package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "time_placed")
    private LocalDateTime timePlaced;
    private String comment;
    @Column(name = "time_updated")
    private LocalDateTime timeUpdated;
    @OneToOne
    Order order;

    public OrderDetails(LocalDateTime timePlaced, String comment, LocalDateTime timeUpdated, Order order) {
        this.timePlaced = timePlaced;
        this.comment = comment;
        this.timeUpdated = timeUpdated;
        this.order = order;
    }
}
