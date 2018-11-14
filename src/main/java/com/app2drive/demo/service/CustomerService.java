package com.app2drive.demo.service;

import com.app2drive.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    double getSpentMoneyByCustomer(String customerName);
}
