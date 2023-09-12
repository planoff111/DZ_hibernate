package org.example.utill;

import org.example.dao.CustomerDaoImpl;
import org.example.dao.OrderDaoImpl;
import org.example.dao.ProductDaoImpl;
import org.example.dao.UserDaoImpl;
import org.example.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    final private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    final private OrderDaoImpl orderDao = new OrderDaoImpl();
    final private ProductDaoImpl productDao = new ProductDaoImpl();
    final private UserDaoImpl userDao = new UserDaoImpl();



    public List<Customer> customersCreate() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "+1 (123) 456-7890"));
        customers.add(new Customer("Alice", "Smith", "+44 20 1234 5678"));
        customers.add(new Customer("Ella", "Johnson", "+33 1 23 45 67 89"));
        customers.add(new Customer("Mohammed", "Al-Mansoori", "+971 50 123 4567"));
        customers.add(new Customer("Maria", "Gonzalez", "+34 91 234 56 78"));
        customers.forEach(customerDao::saveCustomer);
        return customers;
    }

    public List<Order> createOrders(List<Customer> customers,List<OrderDetails> details,List<Product> products) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Order 1", 200.35, customers.get(0),details.get(0),products));
        orders.add(new Order("Order 2", 75.5, customers.get(0),details.get(1),products));
        orders.add(new Order("Order 3", 200.25, customers.get(1),details.get(2),products));
        orders.add(new Order("Order 4", 123.25, customers.get(1),details.get(3),products));
        orders.add(new Order("Order 5", 300.75, customers.get(2),details.get(4),products));
        orders.add(new Order("Order 6", 85.0, customers.get(2),details.get(5),products));
        orders.add(new Order("Order 7", 150.50, customers.get(3),details.get(6),products));
        orders.add(new Order("Order 8", 95.25, customers.get(3),details.get(7),products));
        orders.add(new Order("Order 9", 120.0, customers.get(4),details.get(8),products));
        orders.add(new Order("Order 10", 180.0, customers.get(4),details.get(9),products));
        orders.forEach(orderDao::saveOrder);
        return orders;
    }

    public List<OrderDetails> createOrderDetails() {

        List<OrderDetails> details = new ArrayList<>();
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 10, 30),
                "Received payment for order #1",
                LocalDateTime.of(2023, 8, 4, 12, 30)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 10, 30),
                "Received payment for order #1",
                LocalDateTime.of(2023, 8, 4, 11, 15)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 11, 45),
                "Preparing order #2 for shipping",
                LocalDateTime.of(2023, 8, 4, 13, 0)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 13, 30),
                "Delivered order #3 to customer",
                LocalDateTime.of(2023, 8, 4, 13, 45)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 14, 15),
                "Processing return for order #4",
                LocalDateTime.of(2023, 8, 4, 15, 0)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 15, 30),
                "Shipped order #5 via express delivery",
                LocalDateTime.of(2023, 8, 4, 16, 15)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 16, 45),
                "Received new stock for order #6",
                LocalDateTime.of(2023, 8, 4, 17, 30)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 18, 0),
                "Customer requested customization for order #7",
                LocalDateTime.of(2023, 8, 4, 18, 45)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 19, 15),
                "Order #8 ready for pickup at our store",
                LocalDateTime.of(2023, 8, 4, 19, 45)));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 20, 30),
                "Order #9 scheduled for delivery tomorrow",
                LocalDateTime.of(2023, 8, 4, 20, 45)));
        details.forEach(orderDao::saveOrderDetails);
        return details;
    }

    public List<Product> createProducts() {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 10.0, 50.0));
        products.add(new Product("Product 2", 15.5, 30.0));
        products.add(new Product("Product 3", 20.25, 25.0));
        products.add(new Product("Product 4", 5.0, 100.0));
        products.add(new Product("Product 5", 30.75, 40.0));
        products.add(new Product("Product 6", 8.0, 60.0));
        products.add(new Product("Product 7", 12.5, 45.0));
        products.add(new Product("Product 8", 18.25, 35.0));
        products.add(new Product("Product 9", 22.0, 20.0));
        products.add(new Product("Product 10", 27.0, 15.0));
        products.add(new Product("Product 11", 11.5, 55.0));
        products.add(new Product("Product 12", 9.75, 70.0));
        products.add(new Product("Product 13", 14.0, 65.0));
        products.add(new Product("Product 14", 6.5, 90.0));
        products.add(new Product("Product 15", 25.0, 25.0));
        products.add(new Product("Product 16", 17.0, 50.0));
        products.add(new Product("Product 17", 13.25, 75.0));
        products.add(new Product("Product 18", 19.5, 40.0));
        products.add(new Product("Product 19", 8.75, 80.0));
        products.add(new Product("Product 20", 24.5, 30.0));
        products.forEach(productDao::saveProduct);
        return products;
    }

    public void createUser(List<Customer> customers) {
        List<User> users = new ArrayList<>();
        users.add(new User("User1", "user1@example.com", "Customer", customers.get(0)));
        users.add(new User("User2", "user2@example.com", "Customer", customers.get(1)));
        users.add(new User("User3", "user3@example.com", "Customer", customers.get(2)));
        users.add(new User("User4", "user4@example.com", "Customer", customers.get(3)));
        users.add(new User("User5", "user5@example.com", "Customer", customers.get(4)));
        users.forEach(userDao::saveUser);

    }
}
