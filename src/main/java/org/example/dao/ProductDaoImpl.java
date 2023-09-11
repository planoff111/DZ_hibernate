package org.example.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.utill.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final Logger logger = LogManager.getLogger(ProductDaoImpl.class);
    final SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public void saveProduct(Product product) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        try{
            session.save(product);
        }catch (Exception e){
            logger.error("product" + product.getName() + " wasnt saved");
        }

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
