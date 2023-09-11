package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class Service {
    private static final Logger logger = LogManager.getLogger(Service.class);
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    final private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    final private OrderDaoImpl orderDao = new OrderDaoImpl();
    final private ProductDaoImpl productDao = new ProductDaoImpl();
    final private UserDaoImpl userDao = new UserDaoImpl();






    public void saveData(){
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        try{
            List<Customer> savedCustomers = customers();
            savedCustomers.forEach(customerDao::saveCustomer);
            List<Order> orders = new ArrayList<>();
            orders.add(new Order("Order 1", 200.35, savedCustomers.get(0)));
            orders.add(new Order("Order 2", 75.5, savedCustomers.get(0)));
            orders.add(new Order("Order 3", 200.25, savedCustomers.get(1)));
            orders.add(new Order("Order 4", 123.25, savedCustomers.get(1)));
            orders.add(new Order("Order 5", 300.75, savedCustomers.get(2)));
            orders.add(new Order("Order 6", 85.0, savedCustomers.get(2)));
            orders.add(new Order("Order 7", 150.50, savedCustomers.get(3)));
            orders.add(new Order("Order 8", 95.25,savedCustomers.get(3)));
            orders.add(new Order("Order 9", 120.0, savedCustomers.get(4)));
            orders.add(new Order("Order 10", 180.0, savedCustomers.get(4)));
            List<Order> savedOrders = orders;
            savedOrders.forEach(orderDao::saveOrder);
            List<OrderDetails> details = new ArrayList<>();
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 10, 30),
                    "Received payment for order #1",
                    LocalDateTime.of(2023, 8, 4, 12, 30), savedOrders.get(0)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 10, 30),
                    "Received payment for order #1",
                    LocalDateTime.of(2023, 8, 4, 11, 15), savedOrders.get(1)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 11, 45),
                    "Preparing order #2 for shipping",
                    LocalDateTime.of(2023, 8, 4, 13, 0), savedOrders.get(2)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 13, 30),
                    "Delivered order #3 to customer",
                    LocalDateTime.of(2023, 8, 4, 13, 45), savedOrders.get(3)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 14, 15),
                    "Processing return for order #4",
                    LocalDateTime.of(2023, 8, 4, 15, 0), savedOrders.get(4)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 15, 30),
                    "Shipped order #5 via express delivery",
                    LocalDateTime.of(2023, 8, 4, 16, 15), savedOrders.get(5)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 16, 45),
                    "Received new stock for order #6",
                    LocalDateTime.of(2023, 8, 4, 17, 30), savedOrders.get(6)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 18, 0),
                    "Customer requested customization for order #7",
                    LocalDateTime.of(2023, 8, 4, 18, 45), savedOrders.get(7)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 19, 15),
                    "Order #8 ready for pickup at our store",
                    LocalDateTime.of(2023, 8, 4, 19, 45), savedOrders.get(8)));
            details.add(new OrderDetails(
                    LocalDateTime.of(2023, 8, 4, 20, 30),
                    "Order #9 scheduled for delivery tomorrow",
                    LocalDateTime.of(2023, 8, 4, 20, 45), savedOrders.get(9)));
            List<OrderDetails> savedDetails = details;
            savedDetails.forEach(orderDao::saveOrderDetails);

            List<Product> products = new ArrayList<>();
            products.add(new Product("Product 1", 10.0, 50.0, savedOrders));
            products.add(new Product("Product 2", 15.5, 30.0, savedOrders));
            products.add(new Product("Product 3", 20.25, 25.0, savedOrders));
            products.add(new Product("Product 4", 5.0, 100.0, savedOrders));
            products.add(new Product("Product 5", 30.75, 40.0, savedOrders));
            products.add(new Product("Product 6", 8.0, 60.0, savedOrders));
            products.add(new Product("Product 7", 12.5, 45.0, savedOrders));
            products.add(new Product("Product 8", 18.25, 35.0, savedOrders));
            products.add(new Product("Product 9", 22.0, 20.0, savedOrders));
            products.add(new Product("Product 10", 27.0, 15.0, savedOrders));
            products.add(new Product("Product 11", 11.5, 55.0, savedOrders));
            products.add(new Product("Product 12", 9.75, 70.0, savedOrders));
            products.add(new Product("Product 13", 14.0, 65.0, savedOrders));
            products.add(new Product("Product 14", 6.5, 90.0, savedOrders));
            products.add(new Product("Product 15", 25.0, 25.0, savedOrders));
            products.add(new Product("Product 16", 17.0, 50.0, savedOrders));
            products.add(new Product("Product 17", 13.25, 75.0, savedOrders));
            products.add(new Product("Product 18", 19.5, 40.0, savedOrders));
            products.add(new Product("Product 19", 8.75, 80.0, savedOrders));
            products.add(new Product("Product 20", 24.5, 30.0, savedOrders));
            products.forEach(productDao::saveProduct);
            List<User> users = new ArrayList<>();
            users.add(new User("User1", "user1@example.com", "Customer",savedCustomers.get(0)));
            users.add(new User("User2", "user2@example.com", "Customer", savedCustomers.get(1)));
            users.add(new User("User3", "user3@example.com", "Customer", savedCustomers.get(2)));
            users.add(new User("User4", "user4@example.com", "Customer", savedCustomers.get(3)));
            users.add(new User("User5", "user5@example.com", "Customer", savedCustomers.get(4)));
            users.forEach(userDao::saveUser);
            t.commit();
            logger.info("data saved succesfully in tables");
        }catch (Exception e){
            t.rollback();
            logger.fatal("fatal error on stage save in tables (look at errors)");
        }

        session.close();
    }

    public void takeAllProducts() {
        productDao.findAllProducts()
                .forEach(product -> System.out.println("Name  " + product.getName()
                        + " price " + product.getPrice() + " Qnty " + product.getQuantity()));
    }

    public void takeQntyOfOrderForUser() {
        orderDao.findQntyOfOrdersForUser().forEach((o -> System.out.println("name customer " + o.getName() +
                " surname " + o.getSurname()
                + " telephone " + o.getPhone() + " qnty of orders for user " + o.getOrders().size())));
    }

    public void takeAllOrdersWithDetailsAscTime() {
        orderDao.findAllOrdersDetailsByDate().forEach(order -> System.out.println("name order " + order.getName()
                + " name of cast " + order.getCustomer().getName()
                + " coment " + order.getDetails().getComment()
                + " time placed " + order.getDetails().getTimePlaced()));
    }

    public void changeDataOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order Id from 1 to 10");
        while (!scanner.hasNextInt()){
            logger.warn("entered data is not a number");
            System.out.println("Enter a number");
            scanner.next();
        }
        int id = scanner.nextInt();
        if(id > 0 && id < 11){
            orderDao.changeOrderData(id);
        }else logger.error("entered number out of range");


    }

    public void findAllOrders() {
        orderDao.findAllOrders()
                .forEach(o -> System.out.println("name order " + o.getName()));
    }

    public void dataForAllCast() {
        userDao.qntyOfProductForUser().forEach((data) -> System.out.println("Username " + data.getUser().getUserName()
                + " Email " + data.getUser().getEmail() + " Role " + data.getUser().getRole()
                + " name " + data.getUser().getCustomer().getName() + " surname " + data.getSurname()
                + " phone " + data.getPhone() + " qnty of orders " + data
                .getOrders().size()));

    }

    private List<Customer> customers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "+1 (123) 456-7890"));
        customers.add(new Customer("Alice", "Smith", "+44 20 1234 5678"));
        customers.add(new Customer("Ella", "Johnson", "+33 1 23 45 67 89"));
        customers.add(new Customer("Mohammed", "Al-Mansoori", "+971 50 123 4567"));
        customers.add(new Customer("Maria", "Gonzalez", "+34 91 234 56 78"));
        return customers;
    }








}
