package com.app2drive.demo.dao;

import com.app2drive.demo.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();

    Double findSpentMoneyByCustomer(String customerName);
}
