package com.rajiv.springboot.repositoryimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.repository.CountryRepo;

@Repository
public class CountryRepoImpl implements CountryRepo {

	private static List<Country> countries = new ArrayList<>();

	static {
		countries.add(new Country(1, "India", "Delhi"));
		countries.add(new Country(2, "USA", "Washington"));
		countries.add(new Country(3, "Australia", "Melbouren"));
		countries.add(new Country(4, "Canada", "Torento"));

	}

	@Override
	public List<Country> getAllCountries() {

		return countries;
	}

	@Override
	public Country getCountryById(int countryId) {
		List<Country> country = this.getAllCountries();
		return country.stream().filter(obj->obj.getId()==countryId).findFirst().get();
	}

	@Override
	public Country getCountryByName(String countryName) {
		/*
		 * for (int key : countryMap.keySet()) { if
		 * (countryMap.get(key).getCountryName().equalsIgnoreCase(countryName)) { return
		 * countryMap.get(key); } }
		 */
		return null;
	}

	@Override
	public Country addCountry(Country country) {
		
		int maxId =countries.stream().collect(Collectors.maxBy(Comparator.comparing(Country::getId))).get().getId();
		country.setId(maxId + 1);
		countries.add(country);
		return country;
	}

	@Override
	public void updateCountry(Country country,int countryId) {
		 countries.stream().map(c->{
			if(c.getId()==countryId) {
				c.setCountryName(country.getCountryName());
				c.setCountryCapital(country.getCountryCapital());
			}return c;
			
		}).collect(Collectors.toList());
		
	}

	@Override
	public void deleteCountry(int countryId) {
		countries=countries.stream().filter(countr->countr.getId()!=countryId).collect(Collectors.toList());
	}

}
