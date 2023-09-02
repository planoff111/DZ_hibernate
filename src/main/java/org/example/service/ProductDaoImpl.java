package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void saveProduct(Product product) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(product);
        t.commit();
        session.close();

    }

    @Override
    public List<Product> findAllProducts() {
        final   Session session = factory.openSession();
        List<Product> products = session.createQuery("FROM Product ").getResultList();
        session.close();
        return products;
    }

    public List<Product> products(){
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
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 10.0, 50.0,order1));
        products.add(new Product("Product 2", 15.5, 30.0,order2));
        products.add(new Product("Product 3", 20.25, 25.0,order2));
        products.add(new Product("Product 4", 5.0, 100.0,order1));
        products.add(new Product("Product 5", 30.75, 40.0,order3));
        products.add(new Product("Product 6", 8.0, 60.0,order3));
        products.add(new Product("Product 7", 12.5, 45.0,order4));
        products.add(new Product("Product 8", 18.25, 35.0,order5));
        products.add(new Product("Product 9", 22.0, 20.0,order4));
        products.add(new Product("Product 10", 27.0, 15.0,order4));
        products.add(new Product("Product 11", 11.5, 55.0,order5));
        products.add(new Product("Product 12", 9.75, 70.0,order5));
        products.add(new Product("Product 13", 14.0, 65.0,order9));
        products.add(new Product("Product 14", 6.5, 90.0,order6));
        products.add(new Product("Product 15", 25.0, 25.0,order6));
        products.add(new Product("Product 16", 17.0, 50.0,order7));
        products.add(new Product("Product 17", 13.25, 75.0,order7));
        products.add(new Product("Product 18", 19.5, 40.0,order8));
        products.add(new Product("Product 19", 8.75, 80.0,order8));
        products.add(new Product("Product 20", 24.5, 30.0,order9));
        return products;
    }
}
