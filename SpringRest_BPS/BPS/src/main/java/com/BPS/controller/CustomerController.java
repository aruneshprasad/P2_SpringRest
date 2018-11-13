package com.BPS.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BPS.customer.entities.CustomerDetails;
import com.BPS.customer.service.CustomerDetailsService;



@RestController
@CrossOrigin
@ComponentScans(value = { @ComponentScan("com.BPS.customer.dao"), @ComponentScan("com.BPS.customer.service") })
@RequestMapping(value = "/customerservice")
public class CustomerController {

	@Autowired
	private CustomerDetailsService cs;
	List<CustomerDetails> customers = null;
	
	@GetMapping(value = "/customers/")
	public ResponseEntity<?> listAll() {
		customers = cs.findAll();
		if (customers.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<CustomerDetails>>(customers, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registercustomer/")
	public ResponseEntity<?> saveCustomer(@RequestBody CustomerDetails customer) {
		customer=cs.addCustomer(customer);
		
		if(customer==null) {
			return new ResponseEntity<String>("Customer not saved", HttpStatus.OK);

		}
		return new ResponseEntity<CustomerDetails>(customer, HttpStatus.OK);
	}

	/*@GetMapping("/{prodId}")
	public ResponseEntity<?> findById(@PathVariable("prodId") String prodId) throws Exception {
		
		if(prodId.equals("P001"))
		throw new Exception();
		
		customer=ps.findById(prodId);
		
		if(!customer.isPresent()) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("Customer id "+prodId+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<Customer>> (customer, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExceptin(Exception e) {
		return new ResponseEntity<String>("Provided URL not valid. make sure its should be /customers/ "+e,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/error")
	public ResponseEntity<String> handleExceptin1() {
		return new ResponseEntity<String>("Provided URL not valid. make sure its should be /customers/ ",HttpStatus.NOT_FOUND);
	}*/

}
