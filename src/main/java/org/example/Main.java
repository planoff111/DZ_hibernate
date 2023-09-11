package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.service.Service;
import org.example.utill.HibernateUtils;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Service service = new Service();
        /*
        service.saveCustomer();
        service.saveOrder();
        service.saveProduct();
        service.saveUser();
        service.saveOrderDetails();*/
        service.saveData();


        System.out.println("All pruducts");
        service.takeAllProducts();
        System.out.println("Qnty of order for user");
        service.takeQntyOfOrderForUser();
        System.out.println("order with detail by Time placed");
        service.takeAllOrdersWithDetailsAscTime();
        System.out.println("Data for all cast ");
        service.dataForAllCast();
        service.changeDataOrder();
        service.findAllOrders();

    }

}