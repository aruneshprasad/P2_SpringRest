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

import com.BPS.vendor.entities.Amount;
import com.BPS.vendor.entities.Country;
import com.BPS.vendor.entities.VendorDetails;
import com.BPS.vendor.service.AmountService;
import com.BPS.vendor.service.CountryService;
import com.BPS.vendor.service.VendorDetailsService;

@RestController
@CrossOrigin
@ComponentScans(value={@ComponentScan("com.BPS.vendor.dao"), @ComponentScan("com.BPS.vendor.service")})
@RequestMapping(value="/vendorservice")
public class VendorController {
	
	@Autowired
	private VendorDetailsService vds;
	@Autowired
	private CountryService cs;
	@Autowired
	private AmountService as;
	
	List<VendorDetails> vendors = null;
	List<Country> countries = null;
	List<Amount> amounts = null;
	Optional<VendorDetails> vendor = null;
	
	@GetMapping(value = "/vendors")
	public ResponseEntity<?> findAll() {
		vendors = vds.findAll();
		if (vendors.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<VendorDetails>>(vendors, HttpStatus.OK);
	}
	
	@GetMapping("/getvendor/{vendorId}")
	public ResponseEntity<?> findById(@PathVariable("vendorId") String vendorId){
		vendor = vds.findById(vendorId);
		
		if(!vendor.isPresent()) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("Vendor with given id "+vendorId+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<VendorDetails>> (vendor, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registervendor/")
	public ResponseEntity<?> saveVendor(@RequestBody VendorDetails vendor) {
		vendor = vds.addVendor(vendor);
		
		if(vendor==null) {
			return new ResponseEntity<String>("Vendor not saved", HttpStatus.OK);

		}
		return new ResponseEntity<VendorDetails>(vendor, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getcountry/{country}")
	public ResponseEntity<?> findByCountryName(@PathVariable("country") String country) {
		countries = cs.findByCountryName(country);
		if (countries.isEmpty()) {
			return new ResponseEntity<Object>("No Records available for given "+country, HttpStatus.OK);
		}

		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getamount/{vendorType}")
	public ResponseEntity<?> findByVendorType(@PathVariable("vendorType") String vendorType) {
		amounts = as.findByVendorType(vendorType);
		if (amounts.isEmpty()) {
			return new ResponseEntity<Object>("No Records available for given "+ vendorType, HttpStatus.OK);
		}

		return new ResponseEntity<List<Amount>>(amounts, HttpStatus.OK);
	}

}
