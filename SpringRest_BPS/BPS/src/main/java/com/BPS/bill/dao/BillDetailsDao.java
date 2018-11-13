package com.BPS.bill.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BPS.bill.entities.BillDetails;

public interface BillDetailsDao extends JpaRepository<BillDetails, String>{
	
	public List<BillDetails> findByOrderByBillIdDesc();

}
