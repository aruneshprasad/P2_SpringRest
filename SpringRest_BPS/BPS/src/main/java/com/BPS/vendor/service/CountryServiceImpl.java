package com.BPS.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BPS.vendor.dao.CountryDao;
import com.BPS.vendor.entities.Country;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryDao cd;

	@Override
	@Transactional
	public List<Country> findByCountryName(String country) {
		return cd.findByCountryName(country);
	}

}
