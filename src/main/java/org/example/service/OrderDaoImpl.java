package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.OrderDetails;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OrderDaoImpl implements OrderDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void saveOrder(Order order) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(order);
        t.commit();
        session.close();
    }


    @Override
    public void saveOrderDetails(OrderDetails order) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(order);
        t.commit();
        session.close();
    }

    @Override
    public List<Order> findAllOrders() {
        final   Session session = factory.openSession();
        List<Order> customers = session.createQuery("FROM Order ").getResultList();
        session.close();
        return customers;
    }

    public HashMap<Customer,Integer> findQntyOfOrdersForUser(){
        final   Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        List<Customer> customers = new ArrayList<>();
        customers.add(session.get(Customer.class, 1));
        customers.add(session.get(Customer.class, 2));
        customers.add(session.get(Customer.class, 3));
        customers.add(session.get(Customer.class, 4));
        customers.add(session.get(Customer.class, 5));

        HashMap<Customer,Integer> customerQnty = new HashMap<>();
        for (Customer customer : customers){
            List<Order> orders = session.createQuery("FROM Order o where o.customer.id =:id ")
                            .setParameter("id",customer.getId()).getResultList();
            int qnty = orders.size();
            customerQnty.put(customer,qnty);

        }
        transaction.commit();
        session.close();

        return customerQnty;
    }

    public HashMap<Order,OrderDetails> findAllOrdersDetailsByDate(){
        final   Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("FROM Order ")
                .getResultList();
        List<OrderDetails> ordersDetails = session.createQuery("FROM OrderDetails ORDER BY timePlaced")
                .getResultList();
            HashMap<Order,OrderDetails> orderWithDetails = new HashMap<>();
            for (int i = 0; i < orders.size(); i++){
                Order order = orders.get(i);
                OrderDetails orderDetail = ordersDetails.get(i);
                orderWithDetails.put(order, orderDetail);
            }

        transaction.commit();
        session.close();
        return orderWithDetails;
    }

    public void changeOrderData(int id){
        final   Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class,id);
        System.out.println(order.getName() + "name before change");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name of order");
        order.setName(scanner.nextLine());
        session.update(order);
        transaction.commit();
        session.close();
        System.out.println(order.getName() + " name after change ");

    }

    public List<Order> orders(){
        final   Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer1 = session.load(Customer.class,1);
        Customer customer2 = session.load(Customer.class,2);
        Customer customer3 = session.load(Customer.class,3);
        Customer customer4 = session.load(Customer.class,4);
        Customer customer5 = session.load(Customer.class,5);
        List<Order> orders =new ArrayList<>();
        orders.add(new Order("Order 1",200.35,customer1));
        orders.add(new Order("Order 2", 75.5,customer2));
        orders.add(new Order("Order 3", 200.25,customer2));
        orders.add(new Order("Order 5", 300.75,customer3));
        orders.add(new Order("Order 6", 85.0,customer3));
        orders.add(new Order("Order 7", 150.50,customer4));
        orders.add(new Order("Order 8", 95.25,customer4));
        orders.add(new Order("Order 9", 120.0,customer5));
        orders.add(new Order("Order 10", 180.0,customer5));
        transaction.commit();
        session.close();
        return orders;
    }

    public List<OrderDetails> detailsOrder (){
        final   Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        Order order1 = session.load(Order.class,1);
        Order order2 = session.load(Order.class,2);
        Order order3 = session.load(Order.class,3);
        Order order4 = session.load(Order.class,4);
        Order order5 = session.load(Order.class,5);
        Order order6 = session.load(Order.class,6);
        Order order7 = session.load(Order.class,7);
        Order order8 = session.load(Order.class,8);
        Order order9 = session.load(Order.class,9);
        List<OrderDetails> details = new ArrayList<>();
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 10, 30),
                "Received payment for order #1",
                LocalDateTime.of(2023, 8, 4, 11, 15),order1));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 11, 45),
                "Preparing order #2 for shipping",
                LocalDateTime.of(2023, 8, 4, 13, 0),order2));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 13, 30),
                "Delivered order #3 to customer",
                LocalDateTime.of(2023, 8, 4, 13, 45),order3));
        details.add( new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 14, 15),
                "Processing return for order #4",
                LocalDateTime.of(2023, 8, 4, 15, 0),order4));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 15, 30),
                "Shipped order #5 via express delivery",
                LocalDateTime.of(2023, 8, 4, 16, 15),order5));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 16, 45),
                "Received new stock for order #6",
                LocalDateTime.of(2023, 8, 4, 17, 30),order6));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 18, 0),
                "Customer requested customization for order #7",
                LocalDateTime.of(2023, 8, 4, 18, 45),order7));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 19, 15),
                "Order #8 ready for pickup at our store",
                LocalDateTime.of(2023, 8, 4, 19, 45),order8));
        details.add(new OrderDetails(
                LocalDateTime.of(2023, 8, 4, 20, 30),
                "Order #9 scheduled for delivery tomorrow",
                LocalDateTime.of(2023, 8, 4, 20, 45),order9));
        transaction.commit();
        session.close();

        return details;
    }
}
