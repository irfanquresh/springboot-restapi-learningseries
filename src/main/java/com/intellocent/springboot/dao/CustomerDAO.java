package com.intellocent.springboot.dao;

import java.util.List;

import com.intellocent.springboot.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();

	public Customer findOne(int theId);

	public void saveOrUpdate(Customer theCustomer);

	public void delete(int theId);

}
