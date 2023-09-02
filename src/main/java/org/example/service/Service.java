package org.example.service;

import java.util.Scanner;

public class Service {
    final private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    final private OrderDaoImpl orderDao = new OrderDaoImpl();
    final private ProductDaoImpl productDao = new ProductDaoImpl();
    final private UserDaoImpl userDao = new UserDaoImpl();

    public void saveCustomer(){
        customerDao.customers().stream()
                .forEach(customer -> customerDao.saveCustomer(customer));
    }

    public void saveOrder(){
        orderDao.orders().stream()
                .forEach(order -> orderDao.saveOrder(order));
    }

    public void saveOrderDetails(){
        orderDao.detailsOrder().stream()
                .forEach(orderDetails -> orderDao.saveOrderDetails(orderDetails));
    }

    public void saveProduct(){
        productDao.products().stream()
                .forEach(product -> productDao.saveProduct(product));

    }

    public void saveUser(){
        userDao.users().stream()
                .forEach(user -> userDao.saveUser(user));

    }

    public void takeAllProducts(){
        productDao.findAllProducts().stream()
                .forEach(product -> System.out.println("Name  " + product.getName()
                + " price " +  product.getPrice() + " Qnty " + product.getQuantity()));
    }

    public void takeQntyOfOrderForUser(){
        orderDao.findQntyOfOrdersForUser().entrySet()
                .forEach(q -> System.out.println("name customer " + q.getKey().getName() +
                        " surname " + q.getKey().getSurname()
                + " telephone " + q.getKey().getPhone() + " qnty of orders for user " + q.getValue() ));
    }

    public void takeAllOrdersWithDetailsAscTime(){
        orderDao.findAllOrdersDetailsByDate().entrySet()
                .forEach(o-> System.out.println("name order " + o.getKey().getName()
                + " name of cast " + o.getKey().getCustomer().getName()
                + " coment "+ o.getKey().getDetails().getComment()
                + " time placed " + o.getKey().getDetails().getTimePlaced()));
    }

    public void changeDataOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order Id from 1 to 9");
         int id = scanner.nextInt();
        orderDao.changeOrderData(id);
    }

    public void findAllOrders(){
        orderDao.findAllOrders().stream()
                .forEach(o-> System.out.println(" name order " + o.getName()));
    }

    public void dataForAllCast(){
        userDao.qntyOfProductForUser().entrySet().forEach(u-> System.out.println(" Username " + u.getKey().getUserName()
        + " Email customer " + u.getKey().getEmail() + " RoleCustomer " + u.getKey().getRole()
        + " name customer " + u.getKey().getCustomer().getName() + " surname " + u.getKey().getCustomer().getSurname()
        + " phone " + u.getKey().getCustomer().getPhone() + " qnty of orders " + u.getValue()));

    }
}
