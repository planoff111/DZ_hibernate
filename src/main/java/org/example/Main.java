package org.example;


import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.OrderDetails;
import org.example.entity.Product;
import org.example.service.Service;
import org.example.utill.DataUtils;
import org.example.utill.HibernateUtils;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();

        Service service = new Service();
        service.startSaveData();


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