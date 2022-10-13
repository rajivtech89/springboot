package com.rajiv.springboot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rajiv.springboot.model.Country;

@Repository
public interface CountryRepo {

	List getAllCountries();

	Country getCountryById(int countryId);

	Country getCountryByName(String countryName);

	Country addCountry(Country country);
	
	void updateCountry(Country country,int countryId);
	
	void deleteCountry(int countryId);
}
