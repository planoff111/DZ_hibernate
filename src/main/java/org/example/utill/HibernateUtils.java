package org.example.utill;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.*;
import org.example.service.Service;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.relation.Role;

public class HibernateUtils {
    private static final Logger logger = LogManager.getLogger(Service.class);
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .addAnnotatedClass(Customer.class)
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(OrderDetails.class)
                        .addAnnotatedClass(Product.class)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                logger.fatal("Session factory does not created");
            }
        }
        return sessionFactory;
    }
}
