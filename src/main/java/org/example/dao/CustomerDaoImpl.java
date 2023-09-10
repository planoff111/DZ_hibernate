package org.example.dao;

import org.example.entity.Customer;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

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
        final Session session = factory.openSession();
        List<Customer> customers = session.createQuery("FROM Customer").getResultList();
        session.close();
        return customers;
    }


}
