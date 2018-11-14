package com.app2drive.demo.dao.impl;

import com.app2drive.demo.dao.CustomerDao;
import com.app2drive.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll() {

        List<Customer> customers = jdbcTemplate.query(
                "SELECT customerNumber, customerName FROM customers",
                (rs, rowNum) -> {
                    Customer customer = new Customer();
                    customer.setCustomerNumber(rs.getInt("customerNumber"));
                    customer.setCustomerName(rs.getString("customerName"));
                    return customer;
                }
        );
        return customers;
    }

    @Override
    public Double findSpentMoneyByCustomer(String customerName) {

        return jdbcTemplate.queryForObject(
                "SELECT SUM(amount) FROM payments p INNER JOIN customers c ON p.customerNumber = c.customerNumber WHERE customerName = ?",
                new Object[]{customerName}, Double.class);
    }
}
