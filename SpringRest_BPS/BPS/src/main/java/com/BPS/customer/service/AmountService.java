package com.BPS.customer.service;

import java.util.List;

import com.BPS.customer.entities.Amount;

public interface AmountService {
	
	public List<Amount> findByVendorType(String vendorType);

}
