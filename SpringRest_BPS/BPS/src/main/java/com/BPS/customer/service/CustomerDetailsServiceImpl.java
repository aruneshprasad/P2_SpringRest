package com.BPS.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BPS.customer.dao.CustomerDetailsDao;
import com.BPS.customer.entities.CustomerDetails;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{

	@Autowired
	private CustomerDetailsDao dao;
	
	@Override
	@Transactional
	public List<CustomerDetails> findAll() {
		return  dao.findAll();
	}

	@Override
	@Transactional
	public CustomerDetails addCustomer(CustomerDetails customer) {
		customer.setCustomerId(generateCustomerId());
		return dao.save(customer);
	}
	
	public String generateCustomerId(){
		StringBuilder prefix= new StringBuilder("C");
		List<CustomerDetails> customers = dao.findByOrderByCustomerIdDesc();
		if(!customers.isEmpty()){
			Integer id = new Integer(customers.get(0).getCustomerId().substring(1));
			id++;
			for(int i=id.toString().length();i<=3;i++)
				prefix.append("0");
			prefix.append(id);
		}
		else{
			prefix.append("0001");
		}
		return prefix.toString();
	}

}
