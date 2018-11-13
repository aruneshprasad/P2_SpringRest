package com.BPS.vendor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BPS.vendor.entities.VendorDetails;

public interface VendorDetailsDao extends JpaRepository<VendorDetails, String>{
	
	public List<VendorDetails> findByOrderByVendorIdDesc();

}
