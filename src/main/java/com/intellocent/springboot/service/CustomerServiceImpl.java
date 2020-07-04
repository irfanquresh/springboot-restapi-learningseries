package com.intellocent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellocent.springboot.dao.CustomerDAO;
import com.intellocent.springboot.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO theDAO;
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return theDAO.findAll();
	}
	
	@Override
	@Transactional
	public Customer findOne(int theId) {
		return theDAO.findOne(theId);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Customer theCustomer) {
		theDAO.saveOrUpdate(theCustomer);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		theDAO.delete(theId);
	}
}





