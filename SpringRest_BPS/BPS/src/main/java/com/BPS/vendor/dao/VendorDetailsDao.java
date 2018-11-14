package com.BPS.vendor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BPS.vendor.entities.VendorDetails;

public interface VendorDetailsDao extends JpaRepository<VendorDetails, String>{
	
	public List<VendorDetails> findByOrderByVendorIdDesc();
	
	@Query(value="select * from vendordetails v where v.amount_vendor_type = :vTypeParam", nativeQuery=true)
	List<VendorDetails> findVendorByType(@Param("vTypeParam") String vendorType);

}
