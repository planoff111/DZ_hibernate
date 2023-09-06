package org.example.dao;

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

public class OrderDaoImpl implements OrderDao {
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
        final Session session = factory.openSession();
        List<Order> customers = session.createQuery("FROM Order ").getResultList();
        session.close();
        return customers;
    }

    public HashMap<Customer, Integer> findQntyOfOrdersForUser() {
        final Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        List<Customer> customers = new ArrayList<>();
        customers.add(session.get(Customer.class, 1));
        customers.add(session.get(Customer.class, 2));
        customers.add(session.get(Customer.class, 3));
        customers.add(session.get(Customer.class, 4));
        customers.add(session.get(Customer.class, 5));

        HashMap<Customer, Integer> customerQnty = new HashMap<>();
        for (Customer customer : customers) {
            List<Order> orders = session.createQuery("FROM Order o where o.customer.id =:id ")
                    .setParameter("id", customer.getId()).getResultList();
            int qnty = orders.size();
            customerQnty.put(customer, qnty);

        }
        transaction.commit();
        session.close();

        return customerQnty;
    }

    public List<Order> findAllOrdersDetailsByDate() {
        final Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("FROM Order o  ").getResultList();
        transaction.commit();
        session.close();
        return orders;
    }

    public void changeOrderData(int id) {
        final Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        System.out.println(order.getName() + "name before change");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name of order");
        order.setName(scanner.nextLine());
        session.update(order);
        transaction.commit();
        session.close();
        System.out.println(order.getName() + " name after change ");

    }


}
