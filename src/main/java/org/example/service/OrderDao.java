package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.OrderDetails;

import java.util.List;

public interface OrderDao {
    public void saveOrder(Order order);

    public void saveOrderDetails(OrderDetails order);

    public List<Order> findAllOrders();
}
