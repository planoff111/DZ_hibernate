package org.example.service;

import org.example.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public void saveCustomer(Customer customer);

    public List<Customer> findAllCust();
}
