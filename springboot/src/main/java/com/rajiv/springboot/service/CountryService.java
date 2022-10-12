package com.rajiv.springboot.service;

import java.util.List;

import com.rajiv.springboot.model.Country;

public interface CountryService {
	List getAllCountries();

	Country getCountryById(int countryId);

	Country getCountryByName(String countryName);
	
	Country addCountry(Country country);
	
	Country updateCountry(Country country);
	
	String deleteCountry(int countryId);
}
