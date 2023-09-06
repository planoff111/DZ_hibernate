package org.example.service;

import org.example.dao.CustomerDaoImpl;
import org.example.dao.OrderDaoImpl;
import org.example.dao.ProductDaoImpl;
import org.example.dao.UserDaoImpl;
import org.example.entity.*;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Service {
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    final private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    final private OrderDaoImpl orderDao = new OrderDaoImpl();
    final private ProductDaoImpl productDao = new ProductDaoImpl();
    final private UserDaoImpl userDao = new UserDaoImpl();

    public void saveCustomer() {
        customers().forEach(customerDao::saveCustomer);
    }

    public void saveOrder() {
        orders()
                .forEach(orderDao::saveOrder);
    }

    public void saveOrderDetails() {
        detailsOrder()
                .forEach(orderDao::saveOrderDetails);
    }

    public void saveProduct() {
        products()
                .forEach(productDao::saveProduct);

    }

    public void saveUser() {
        users()
                .forEach(userDao::saveUser);

    }

    public void takeAllProducts() {
        productDao.findAllProducts()
                .forEach(product -> System.out.println("Name  " + product.getName()
                        + " price " + product.getPrice() + " Qnty " + product.getQuantity()));
    }

    public void takeQntyOfOrderForUser() {
        orderDao.findQntyOfOrdersForUser().forEach((key, value) -> System.out.println("name customer " + key.getName() +
                " surname " + key.getSurname()
                + " telephone " + key.getPhone() + " qnty of orders for user " + value));
    }

    public void takeAllOrdersWithDetailsAscTime() {
        orderDao.findAllOrdersDetailsByDate().forEach(order -> System.out.println("name order " + order.getName()
                + " name of cast " + order.getCustomer().getName()
                + " coment " + order.getDetails().getComment()
                + " time placed " + order.getDetails().getTimePlaced()));
    }

    public void changeDataOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order Id from 1 to 9");
        int id = scanner.nextInt();
        orderDao.changeOrderData(id);
    }

    public void findAllOrders() {
        orderDao.findAllOrders()
                .forEach(o -> System.out.println("name order " + o.getName()));
    }

    public void dataForAllCast() {
        userDao.qntyOfProductForUser().forEach((key, value) -> System.out.println("Username " + key.getUserName()
                + " Email customer " + key.getEmail() + " RoleCustomer " + key.getRole()
                + " name customer " + key.getCustomer().getName() + " surname " + key.getCustomer().getSurname()
                + " phone " + key.getCustomer().getPhone() + " qnty of orders " + value));

    }

    public List<Customer> customers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "+1 (123) 456-7890"));
        customers.add(new Customer("Alice", "Smith", "+44 20 1234 5678"));
        customers.add(new Customer("Ella", "Johnson", "+33 1 23 45 67 89"));
        customers.add(new Customer("Mohammed", "Al-Mansoori", "+971 50 123 4567"));
        customers.add(new Customer("Maria", "Gonzalez", "+34 91 234 56 78"));
        return customers;
    }

    public List<Order> orders() {
        final Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer1 = session.load(Customer.class, 1);
        Customer customer2 = session.load(Customer.class, 2);
        Customer customer3 = session.load(Customer.class, 3);
        Customer customer4 = session.load(Customer.class, 4);
        Customer customer5 = session.load(Customer.class, 5);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Order 1", 200.35, customer1));
        orders.add(new Order("Order 2", 75.5, customer2));
        orders.add(new Order("Order 3", 200.25, customer2));
        orders.add(new Order("Order 5", 300.75, customer3));
        orders.add(new Order("Order 6", 85.0, customer3));
        orders.add(new Order("Order 7", 150.50, customer4));
        orders.add(new Order("Order 8", 95.25, customer4));
        orders.add(new Order("Order 9", 120.0, customer5));
        orders.add(new Order("Order 10", 180.0, customer5));
        transaction.commit();
        session.close();
        return orders;
    }

    public List<OrderDetails> detailsOrder() {
        final Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        Order order1 = session.load(Order.class, 1);
        Order order2 = session.load(Order.class, 2);
        Order order3 = session.load(Order.class, 3);
        Order order4 = session.load(Order.class, 4);
        Order order5 = session.load(Order.class, 5);
        Order order6 = session.load(Order.class, 6);
        Order order7 = session.load(Order.class, 7);
        Order order8 = session.load(Order.class, 8);
        Order order9 = session.load(Order.class, 9);
        List<OrderDetails> details = new ArrayList<>();
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 10, 30),
                "Received payment for order #1",
                LocalDateTime.of(2023, 8, 4, 11, 15), order1));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 11, 45),
                "Preparing order #2 for shipping",
                LocalDateTime.of(2023, 8, 4, 13, 0), order2));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 13, 30),
                "Delivered order #3 to customer",
                LocalDateTime.of(2023, 8, 4, 13, 45), order3));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 14, 15),
                "Processing return for order #4",
                LocalDateTime.of(2023, 8, 4, 15, 0), order4));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 15, 30),
                "Shipped order #5 via express delivery",
                LocalDateTime.of(2023, 8, 4, 16, 15), order5));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 16, 45),
                "Received new stock for order #6",
                LocalDateTime.of(2023, 8, 4, 17, 30), order6));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 18, 0),
                "Customer requested customization for order #7",
                LocalDateTime.of(2023, 8, 4, 18, 45), order7));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 19, 15),
                "Order #8 ready for pickup at our store",
                LocalDateTime.of(2023, 8, 4, 19, 45), order8));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 20, 30),
                "Order #9 scheduled for delivery tomorrow",
                LocalDateTime.of(2023, 8, 4, 20, 45), order9));
        transaction.commit();
        session.close();

        return details;
    }

    public List<Product> products() {
        final Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        Order order1 = session.load(Order.class, 1);
        Order order2 = session.load(Order.class, 2);
        Order order3 = session.load(Order.class, 3);
        Order order4 = session.load(Order.class, 4);
        Order order5 = session.load(Order.class, 5);
        Order order6 = session.load(Order.class, 6);
        Order order7 = session.load(Order.class, 7);
        Order order8 = session.load(Order.class, 8);
        Order order9 = session.load(Order.class, 9);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 10.0, 50.0, order1));
        products.add(new Product("Product 2", 15.5, 30.0, order2));
        products.add(new Product("Product 3", 20.25, 25.0, order2));
        products.add(new Product("Product 4", 5.0, 100.0, order1));
        products.add(new Product("Product 5", 30.75, 40.0, order3));
        products.add(new Product("Product 6", 8.0, 60.0, order3));
        products.add(new Product("Product 7", 12.5, 45.0, order4));
        products.add(new Product("Product 8", 18.25, 35.0, order5));
        products.add(new Product("Product 9", 22.0, 20.0, order4));
        products.add(new Product("Product 10", 27.0, 15.0, order4));
        products.add(new Product("Product 11", 11.5, 55.0, order5));
        products.add(new Product("Product 12", 9.75, 70.0, order5));
        products.add(new Product("Product 13", 14.0, 65.0, order9));
        products.add(new Product("Product 14", 6.5, 90.0, order6));
        products.add(new Product("Product 15", 25.0, 25.0, order6));
        products.add(new Product("Product 16", 17.0, 50.0, order7));
        products.add(new Product("Product 17", 13.25, 75.0, order7));
        products.add(new Product("Product 18", 19.5, 40.0, order8));
        products.add(new Product("Product 19", 8.75, 80.0, order8));
        products.add(new Product("Product 20", 24.5, 30.0, order9));
        transaction.commit();
        session.close();

        return products;
    }

    public List<User> users() {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        Customer user1 = session.get(Customer.class, 1);
        Customer user2 = session.get(Customer.class, 2);
        Customer user3 = session.get(Customer.class, 3);
        Customer user4 = session.get(Customer.class, 4);
        Customer user5 = session.get(Customer.class, 5);
        List<User> users = new ArrayList<>();
        users.add(new User("User1", "user1@example.com", "Customer", user1));
        users.add(new User("User2", "user2@example.com", "Customer", user2));
        users.add(new User("User3", "user3@example.com", "Customer", user3));
        users.add(new User("User4", "user4@example.com", "Customer", user4));
        users.add(new User("User5", "user5@example.com", "Customer", user5));
        t.commit();
        session.close();
        return users;
    }
}
