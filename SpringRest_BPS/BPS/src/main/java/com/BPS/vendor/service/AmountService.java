package com.BPS.vendor.service;

import java.util.List;

import com.BPS.vendor.entities.Amount;

public interface AmountService {
	
	public List<Amount> findByVendorType(String vendorType);

}
