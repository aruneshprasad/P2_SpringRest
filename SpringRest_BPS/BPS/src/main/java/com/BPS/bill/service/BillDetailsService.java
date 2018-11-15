package com.BPS.bill.service;

import java.util.List;

import com.BPS.bill.entities.BillDetails;

public interface BillDetailsService {
	
	List<BillDetails> findAll();
	public BillDetails addBill(BillDetails bill);
	
	public List<BillDetails> findByOrderByBillIdDesc();

}
