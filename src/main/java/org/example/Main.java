package org.example;


import org.example.service.Service;
import org.example.utill.HibernateUtils;


public class Main {
    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Service service = new Service();

        service.saveCustomer();
        service.saveOrder();
        service.saveProduct();
        service.saveUser();
        service.saveOrderDetails();

        service.takeAllProducts();
        service.takeQntyOfOrderForUser();
        service.takeAllOrdersWithDetailsAscTime();
        service.dataForAllCast();
        service.changeDataOrder();
        service.findAllOrders();


    }

}