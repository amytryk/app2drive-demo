package com.app2drive.demo.service.impl;

import com.app2drive.demo.dao.CustomerDao;
import com.app2drive.demo.model.Customer;
import com.app2drive.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    @Override
    public double getSpentMoneyByCustomer(String customerName) {
        Double amount = customerDao.findSpentMoneyByCustomer(customerName);

        if (amount == null) {
            return 0;
        }
        return amount;
    }
}
