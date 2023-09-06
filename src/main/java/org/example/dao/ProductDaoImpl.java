package org.example.dao;

import org.example.entity.Order;
import org.example.entity.Product;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
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
        final Session session = factory.openSession();
        List<Product> products = session.createQuery("FROM Product ").getResultList();
        session.close();
        return products;
    }


}
