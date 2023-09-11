package org.example.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.User;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void saveUser(User user) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        try{
            session.save(user);
        }catch (Exception e){
            logger.error("User " + user.getCustomer().getName() + " wasnt saved" );
        }
        logger.info("user has been saved");
        t.commit();
        session.close();

    }

    public List<Customer> qntyOfProductForUser() {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        List<Customer> users = session.createQuery("FROM Customer  ").getResultList();
        t.commit();
        session.close();
        return users;
    }

    @Override
    public List<User> findAllUsers() {
        final Session session = factory.openSession();
        List<User> users = session.createQuery("FROM User ").getResultList();
        session.close();
        return users;
    }


}
