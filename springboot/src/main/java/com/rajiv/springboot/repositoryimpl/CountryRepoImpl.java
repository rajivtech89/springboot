package com.rajiv.springboot.repositoryimpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.repository.CountryRepo;
@Repository
public class CountryRepoImpl implements CountryRepo {

	static HashMap<Integer, Country> countryMap;

	public HashMap<Integer, Country> getAllCountriesFromDB() {
		countryMap = new HashMap<Integer, Country>();
		countryMap.put(1, new Country(1, "India", "Delhi"));
		countryMap.put(2, new Country(2, "USA", "Washington"));
		countryMap.put(3, new Country(3, "Australia", "Melbouren"));
		countryMap.put(4, new Country(4, "Canada", "Torento"));
		return countryMap;
	}

	@Override
	public List<String> getAllCountries() {
		HashMap<Integer, Country> countryMap = this.getAllCountriesFromDB();

		return new ArrayList(countryMap.values());
	}

	@Override
	public Country getCountryById(int countryId) {
		HashMap<Integer, Country> countryMap = this.getAllCountriesFromDB();
		return countryMap.get(countryId);
	}

	@Override
	public Country getCountryByName(String countryName) {
		HashMap<Integer, Country> countryMap = this.getAllCountriesFromDB();
		for (int key : countryMap.keySet()) {
			if (countryMap.get(key).getCountryName().equalsIgnoreCase(countryName)) {
				return countryMap.get(key);
			}
		}
		return null;
	}

	@Override
	public Country addCountry(Country country) {
		HashMap<Integer, Country> countryMap = this.getAllCountriesFromDB();
		int maxId = countryMap.values().stream().sorted(Comparator.comparingInt(Country::getId).reversed()).findFirst().get().getId();
		country.setId(maxId+1);
		countryMap.put(maxId+1, country);
		return country;
	}

	@Override
	public Country updateCountry(Country country) {
		HashMap<Integer, Country> countryMap = this.getAllCountriesFromDB();
		countryMap.put(country.getId(), country);
		return country;
	}

	@Override
	public String deleteCountry(int countryId) {
		HashMap<Integer, Country> countryMap = this.getAllCountriesFromDB();
		countryMap.remove(countryId);
		return "country deleted";
	}

}
