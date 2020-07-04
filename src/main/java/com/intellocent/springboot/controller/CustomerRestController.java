package com.intellocent.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellocent.springboot.entity.Customer;
import com.intellocent.springboot.entity.Student;
import com.intellocent.springboot.pojo.ExceptionErrorResponse;
import com.intellocent.springboot.pojo.ObjectNotFoundException;
import com.intellocent.springboot.service.CustomerService;

@RestController
@RequestMapping("/v0/api/master")
public class CustomerRestController {

	@Autowired
	private CustomerService theCustomerService;

	// define endpoint for "/customers" - return list of customers
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return theCustomerService.findAll();
	}

	// define endpoint for "/customers/{theId}" - return customer at index
	@GetMapping("/customers/{theId}")
	public Customer findOne(@PathVariable int theId) {

		if (theId < 0) {
			throw new ObjectNotFoundException("Customer id not found - " + theId);
		}

		Customer mCustomer = theCustomerService.findOne(theId);
		if (mCustomer == null) {
			throw new ObjectNotFoundException("Customer id not found - " + theId);
		}

		return mCustomer;
	}

	// define endpoint for "/customers" - Add customer
	@PostMapping("/customers")
	public Customer create(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		theCustomerService.saveOrUpdate(theCustomer);
		return theCustomer;
	}

	// define endpoint for "/customers" - Update customer
	@PutMapping("/customers")
	public Customer update(@RequestBody Customer theCustomer) {
		theCustomerService.saveOrUpdate(theCustomer);
		return theCustomer;
	}

	// define endpoint for "/customers" - Delete customer
	@DeleteMapping("/customers/{theId}")
	public String delete(@PathVariable int theId) {

		Customer mCustomer = theCustomerService.findOne(theId);
		if (mCustomer == null) {
			throw new ObjectNotFoundException("Customer id not found - " + theId);
		}

		theCustomerService.delete(theId);
		return "Record deleted - " + theId;
	}
}
