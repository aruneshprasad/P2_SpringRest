package com.BPS.vendor.service;

import java.util.List;

import com.BPS.vendor.entities.Country;

public interface CountryService {
	
	public List<Country> findByCountryName(String country);
	public List<Country> findCountryId(String country, String state);

}
