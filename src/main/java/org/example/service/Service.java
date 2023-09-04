package org.example.service;

import java.util.Scanner;

public class Service {
    final private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    final private OrderDaoImpl orderDao = new OrderDaoImpl();
    final private ProductDaoImpl productDao = new ProductDaoImpl();
    final private UserDaoImpl userDao = new UserDaoImpl();

    public void saveCustomer(){
        customerDao.customers()
                .forEach(customerDao::saveCustomer);
    }

    public void saveOrder(){
        orderDao.orders()
                .forEach(orderDao::saveOrder);
    }

    public void saveOrderDetails(){
        orderDao.detailsOrder()
                .forEach(orderDao::saveOrderDetails);
    }

    public void saveProduct(){
        productDao.products()
                .forEach(productDao::saveProduct);

    }

    public void saveUser(){
        userDao.users()
                .forEach(userDao::saveUser);

    }

    public void takeAllProducts(){
        productDao.findAllProducts()
                .forEach(product -> System.out.println("Name  " + product.getName()
                + " price " +  product.getPrice() + " Qnty " + product.getQuantity()));
    }

    public void takeQntyOfOrderForUser(){
        orderDao.findQntyOfOrdersForUser().forEach((key, value) -> System.out.println("name customer " + key.getName() +
                " surname " + key.getSurname()
                + " telephone " + key.getPhone() + " qnty of orders for user " + value));
    }

    public void takeAllOrdersWithDetailsAscTime(){
        orderDao.findAllOrdersDetailsByDate().forEach((key, value) -> System.out.println("name order " + key.getName()
                + " name of cast " + key.getCustomer().getName()
                + " coment " + key.getDetails().getComment()
                + " time placed " + key.getDetails().getTimePlaced()));
    }

    public void changeDataOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order Id from 1 to 9");
         int id = scanner.nextInt();
        orderDao.changeOrderData(id);
    }

    public void findAllOrders(){
        orderDao.findAllOrders()
                .forEach(o-> System.out.println(" name order " + o.getName()));
    }

    public void dataForAllCast(){
        userDao.qntyOfProductForUser().forEach((key, value) -> System.out.println(" Username " + key.getUserName()
                + " Email customer " + key.getEmail() + " RoleCustomer " + key.getRole()
                + " name customer " + key.getCustomer().getName() + " surname " + key.getCustomer().getSurname()
                + " phone " + key.getCustomer().getPhone() + " qnty of orders " + value));

    }
}
