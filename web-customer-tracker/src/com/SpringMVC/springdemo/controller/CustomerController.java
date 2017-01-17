package com.SpringMVC.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringMVC.springdemo.customerDAO.CustomerDAO;
import com.SpringMVC.springdemo.entity.CrewMember;
import com.SpringMVC.springdemo.entity.Customer;
import com.SpringMVC.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao, after we will inject customer service
	@Autowired
	@Qualifier()
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
	
		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customer to the model			
		theModel.addAttribute("customers", theCustomers);		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		// create a model attribute to bind form data
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);				
						
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		// save the customer using our service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";		
	}
		
		
	
}













