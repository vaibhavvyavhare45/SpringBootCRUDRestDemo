package com.prowings.service;

import java.util.List;

import com.prowings.model.Client;
import com.prowings.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers();

	//Customer getCustomerById(int id);
	Client getCustomerById(int id);

	void updateCustomer(Customer customer);

	void deleteCustomerById(int id);

	

	

}
