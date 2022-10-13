package com.rajiv.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.repository.CountryRepo;
import com.rajiv.springboot.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepo repo;
	@Override
	public List getAllCountries() {
		return repo.getAllCountries();
	}
	@Override
	public Country getCountryById(int countryId) {
		return repo.getCountryById(countryId);
	}
	@Override
	public Country getCountryByName(String countryName) {
		return repo.getCountryByName(countryName);
	}
	@Override
	public Country addCountry(Country country) {
		return repo.addCountry(country);
	}
	@Override
	public void updateCountry(Country country,int countryId) {
		 repo.updateCountry(country,countryId);
	}
	@Override
	public void deleteCountry(int countryId) {
		 repo.deleteCountry(countryId);
	}

}
