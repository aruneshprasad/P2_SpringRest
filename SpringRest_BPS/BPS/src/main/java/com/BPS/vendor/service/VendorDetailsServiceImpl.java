package com.BPS.vendor.service;

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
		vendor.setVendorId(generateVendorId());
		return dao.save(vendor);
	}
	
	@Override
	public Optional<VendorDetails> findById(String vendorId) {
		return dao.findById(vendorId);
	}
	
	public String generateVendorId(){
		StringBuilder prefix= new StringBuilder("V");
		List<VendorDetails> vendors = dao.findByOrderByVendorIdDesc();
		if(!vendors.isEmpty()){
			Integer id = new Integer(vendors.get(0).getVendorId().substring(1));
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
