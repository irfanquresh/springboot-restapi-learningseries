package com.intellocent.springboot.service;

import java.util.List;

import com.intellocent.springboot.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findOne(int theId);

	public void saveOrUpdate(Customer theCustomer);

	public void delete(int theId);

}
