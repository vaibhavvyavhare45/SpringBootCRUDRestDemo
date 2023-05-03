package com.prowings.service;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.prowings.dao.CustomerDao;
import com.prowings.model.Client;
import com.prowings.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao cdao;
	@Autowired
	DozerBeanMapper mapper;

	@Override
	public Customer saveCustomer(Customer customer) {
		
		return cdao.save(customer);
		
	}

	@Override
	public List<Customer> getAllCustomers() {

		return cdao.findAll();
	}

	@Override
//	public Customer getCustomerById(int id) {
//		Optional<Customer> p = cdao.findById(id);
//		// return cdao.findById(id).get();
//		Customer cust = new Customer();
//		if (p.isPresent()) {
//			mapper.map(p.get(), cust);
//		}
//		if (p.isEmpty())
//			throw new NoSuchElementException("No Record present with this Id!!");
//		else
//			return cust;
		
	public Client getCustomerById(int id)
	{
		
		
		//Optional<Customer> opt = cdao.findById(id);
		
		Customer customer = cdao.findById(id).get();
		
		System.out.println(customer);
		
		
		
		Client client = new Client();
		
		  mapper.map(customer, client);
		  
		  System.out.println(client);
		  
		  return client;		
		
	}
	

	@Override
	public void updateCustomer(Customer customer) {
		Customer cd = cdao.findById(customer.getId()).orElseThrow();
		cdao.save(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		try {
			cdao.deleteById(id);
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
	

}
