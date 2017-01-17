package com.SpringMVC.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.springdemo.customerDAO.CustomerDAO;
import com.SpringMVC.springdemo.entity.Customer;

@Service
public class CustomerSerivceImpl implements CustomerService {

	// inject customer dao
	@Autowired	
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();				
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
		
		
	}

}
