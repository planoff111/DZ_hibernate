package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    private String email;
    private String role;
    @OneToOne
    Customer customer;

    public User(String userName, String email, String role, Customer customer) {
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.customer = customer;
    }
}
