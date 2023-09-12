package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.CustomerDaoImpl;
import org.example.dao.OrderDaoImpl;
import org.example.dao.ProductDaoImpl;
import org.example.dao.UserDaoImpl;
import org.example.entity.*;
import org.example.utill.DataUtils;
import org.example.utill.HibernateUtils;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private static final Logger logger = LogManager.getLogger(Service.class);

    final private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    final private OrderDaoImpl orderDao = new OrderDaoImpl();
    final private ProductDaoImpl productDao = new ProductDaoImpl();
    final private UserDaoImpl userDao = new UserDaoImpl();
    DataUtils utils = new DataUtils();




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
        while (!scanner.hasNextInt()) {
            logger.warn("entered data is not a number");
            System.out.println("Enter a number");
            scanner.next();
        }
        int id = scanner.nextInt();
        if (id > 0 && id < 11) {
            orderDao.changeOrderData(id);
        } else logger.error("entered number out of range");


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


    public void startSaveData(){
        logger.info("Star save to DB");
        List<OrderDetails> details = utils.createOrderDetails();
        List<Customer> customers = utils.customersCreate();
        List<Product> products = utils.createProducts();
        utils.createOrders(customers, details,products);
        utils.createUser(customers);

    }



}
