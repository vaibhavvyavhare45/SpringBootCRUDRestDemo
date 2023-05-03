package com.prowings.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.exception.CustomerNotFoundException;
import com.prowings.model.Client;
import com.prowings.model.Customer;
import com.prowings.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService custService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return custService.saveCustomer(customer);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return custService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public Client getCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException{
		
	    return custService.getCustomerById(id);  
	}

	@PutMapping
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		try {
			custService.updateCustomer(customer);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") int id) {
		try {
			custService.deleteCustomerById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

}
