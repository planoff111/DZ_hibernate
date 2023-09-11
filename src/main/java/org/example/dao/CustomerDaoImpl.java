package org.example.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Customer;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class CustomerDaoImpl implements CustomerDao {

    final SessionFactory factory = HibernateUtils.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class);

    @Override
    public void saveCustomer(Customer customer) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        try{
            session.save(customer);
        } catch (Exception e){
            logger.error("Customer " + customer.getName() +  "  wasnt saved");
        }
        t.commit();
        logger.info("Castomer has been saved correctly ");
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
