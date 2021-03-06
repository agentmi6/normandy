package com.SpringMVC.springdemo.customerDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override	
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query 
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class); 
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results			
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
	    currentSession.save(customer);				
		
	}
}




