package com.BPS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BPS.bill.entities.BillDetails;
import com.BPS.bill.entities.BillSaveHolder;
import com.BPS.bill.service.BillDetailsService;
import com.BPS.customer.entities.CustomerDetails;

@RestController
@CrossOrigin
@ComponentScans(value={@ComponentScan("com.BPS.bill.dao"), @ComponentScan("com.BPS.bill.service")})
@RequestMapping(value="/billservice")
public class BillController {
	
	@Autowired
	private BillDetailsService bs;
	
	List<BillDetails> bills = null;
	
	@GetMapping(value = "/bills")
	public ResponseEntity<?> findAll() {
		bills = bs.findAll();
		if (bills.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}
		return new ResponseEntity<List<BillDetails>>(bills, HttpStatus.OK);
	}
	
	@PostMapping(value = "/generate/")
	public ResponseEntity<?> generateBill(@RequestBody BillSaveHolder bsh) {
		
		BillDetails bill = new BillDetails();
		
		bill.setCustId(bsh.getCustomerId());
		//bill.setVendorId(bsh.getv);
		
		if(bill==null) {
			return new ResponseEntity<String>("Bill not saved", HttpStatus.OK);

		}
		return new ResponseEntity<BillDetails>(bill, HttpStatus.OK);
	}

}
