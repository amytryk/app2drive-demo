package com.app2drive.demo.controller;

import com.app2drive.demo.dto.GetAmountForm;
import com.app2drive.demo.model.Customer;
import com.app2drive.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("customers")
    public String getCustomersPage(Model model) {
        LOG.info("Access /customers");

        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @RequestMapping("customers/spentMoney")
    public String getSpentMoneyPage() {
        LOG.info("Access /customers/spentMoney");
        return "spentMoney";
    }

    @RequestMapping(value = "/customers/spentMoney", method = RequestMethod.POST)
    @ResponseBody
    public double getAmount(@RequestBody GetAmountForm form) {

        return customerService.getSpentMoneyByCustomer(form.getCustomerName());
    }
}
