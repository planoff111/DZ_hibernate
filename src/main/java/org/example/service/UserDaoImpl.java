package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.entity.User;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements  UserDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void saveUser(User user) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        session.close();

    }

    public HashMap<User,Integer> qntyOfProductForUser(){
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        List<User> users = session.createQuery("FROM User ").getResultList();
        HashMap<User,Integer> usersQnty = new HashMap<>();
        for (User user: users){
            List<Product> products = session.createQuery("FROM Product o where o.order.id =:id ")
                    .setParameter("id",user.getCustomer().getId()).getResultList();
            int qnty = products.size();
            usersQnty.put(user,qnty);
        }

        return usersQnty;
    }

    @Override
    public List<User> findAllUsers() {
        final   Session session = factory.openSession();
        List<User> users = session.createQuery("FROM User ").getResultList();
        session.close();
        return users;
    }

    public List<User> users (){
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        Customer user1 = session.get(Customer.class, 1);
        Customer user2 = session.get(Customer.class, 2);
        Customer user3 = session.get(Customer.class, 3);
        Customer user4 = session.get(Customer.class, 4);
        Customer user5 = session.get(Customer.class, 5);
        List<User> users = new ArrayList<>();
        users.add(new User("User1", "user1@example.com", "Customer",user1));
        users.add(new User("User2", "user2@example.com", "Customer",user2));
        users.add(new User("User3", "user3@example.com", "Customer",user3));
        users.add(new User("User4", "user4@example.com", "Customer",user4));
        users.add(new User("User5", "user5@example.com", "Customer",user5));
        t.commit();
        session.close();
        return  users;
    }
}
