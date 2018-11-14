package com.BPS.vendor.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BPS.vendor.dao.VendorDetailsDao;
import com.BPS.vendor.entities.VendorDetails;

@Service
public class VendorDetailsServiceImpl implements VendorDetailsService{
	
	@Autowired
	private VendorDetailsDao dao;

	@Override
	@Transactional
	public List<VendorDetails> findAll() {
		return  dao.findAll();
	}

	@Override
	@Transactional
	public VendorDetails addVendor(VendorDetails vendor) {
		
		int now = LocalDate.now().getYear();
		int yos = now-vendor.getYearOfEstablishment();
		if((yos>=0 && yos<5)) vendor.setCertificate("A+");
		else if ((yos>=5 && yos<10)) vendor.setCertificate("B+");
		else if ((yos>=10 && yos<15)) vendor.setCertificate("C+");
		else if ((yos>=15 && yos<25)) vendor.setCertificate("D+");
		else if ((yos>=25 && yos<50)) vendor.setCertificate("E+");
		else if ((yos>=50)) vendor.setCertificate("F+");
		
		return dao.save(vendor);
	}
	
	@Override
	public Optional<VendorDetails> findById(String vendorId) {
		return dao.findById(vendorId);
	}
	
	
	@Override
	public List<VendorDetails> findVendorByType(String vendorType) {
		return dao.findVendorByType(vendorType);
	}

	@Override
	public List<VendorDetails> findByOrderByVendorIdDesc() {
		return dao.findByOrderByVendorIdDesc();
	}
}
