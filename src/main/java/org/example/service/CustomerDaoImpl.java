package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void saveCustomer(Customer customer) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(customer);
        t.commit();
        session.close();
    }

    @Override
    public List<Customer> findAllCust() {
      final   Session session = factory.openSession();
      List<Customer> customers = session.createQuery("FROM Customer").getResultList();
      session.close();
        return customers;
    }

    public List<Customer> customers(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "+1 (123) 456-7890"));
        customers.add(new Customer("Alice", "Smith", "+44 20 1234 5678"));
        customers.add(new Customer("Ella", "Johnson", "+33 1 23 45 67 89"));
        customers.add( new Customer("Mohammed", "Al-Mansoori", "+971 50 123 4567"));
        customers.add(new Customer("Maria", "Gonzalez", "+34 91 234 56 78"));
        return customers;
    }

}
