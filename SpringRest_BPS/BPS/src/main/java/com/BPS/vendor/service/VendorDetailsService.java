package com.BPS.vendor.service;

import java.util.List;
import java.util.Optional;

import com.BPS.vendor.entities.VendorDetails;

public interface VendorDetailsService {
	
	public List<VendorDetails> findAll();
	public VendorDetails addVendor(VendorDetails vendor);
	public Optional<VendorDetails> findById(String vendorId);
	public List<VendorDetails> findVendorByType(String vendorType);
	public List<VendorDetails> findByOrderByVendorIdDesc();

}
