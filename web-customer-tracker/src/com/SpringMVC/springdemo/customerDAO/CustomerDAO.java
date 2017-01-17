package com.SpringMVC.springdemo.customerDAO;

import java.util.List;

import com.SpringMVC.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
}
