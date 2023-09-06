package org.example.dao;

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

    @Override
    public void saveUser(User user) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        session.close();

    }

    public HashMap<User, Integer> qntyOfProductForUser() {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        List<User> users = session.createQuery("FROM User ").getResultList();
        HashMap<User, Integer> usersQnty = new HashMap<>();
        for (User user : users) {
            List<Product> products = session.createQuery("FROM Product o where o.order.id =:id ")
                    .setParameter("id", user.getCustomer().getId()).getResultList();
            int qnty = products.size();
            usersQnty.put(user, qnty);
        }
        t.commit();
        session.close();

        return usersQnty;
    }

    @Override
    public List<User> findAllUsers() {
        final Session session = factory.openSession();
        List<User> users = session.createQuery("FROM User ").getResultList();
        session.close();
        return users;
    }


}
