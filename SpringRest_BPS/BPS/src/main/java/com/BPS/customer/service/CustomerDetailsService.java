package com.BPS.customer.service;

import java.util.List;

import com.BPS.customer.entities.CustomerDetails;

public interface CustomerDetailsService {
	
	public List<CustomerDetails> findAll();
	public CustomerDetails addCustomer(CustomerDetails customer);

}
