package com.BPS.bill.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BPS.bill.dao.BillDetailsDao;
import com.BPS.bill.entities.BillDetails;

@Service
public class BillDetailsServiceImpl implements BillDetailsService{
	
	@Autowired
	private BillDetailsDao dao;

	@Override
	@Transactional
	public List<BillDetails> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public BillDetails addBill(BillDetails bill) {
		bill.setBillId(generateBillId());
		return dao.save(bill);
	}
	
	public String generateBillId(){
		StringBuilder prefix= new StringBuilder("B");
		List<BillDetails> bills = dao.findByOrderByBillIdDesc();
		if(!bills.isEmpty()){
			Integer id = new Integer(bills.get(0).getBillId().substring(1));
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
