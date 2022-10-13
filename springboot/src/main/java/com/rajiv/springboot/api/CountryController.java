package com.rajiv.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService service;

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getCountries() {
		return new ResponseEntity<List<Country>>(service.getAllCountries(), HttpStatus.OK);
	}

	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getCountrById(@PathVariable("id") int id) {
		return new ResponseEntity<Country>(service.getCountryById(id), HttpStatus.OK);
	}

	@PostMapping("/countries")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		Country count = service.addCountry(country);
		return new ResponseEntity<Country>(count, HttpStatus.CREATED);
	}

	@PutMapping("/countries/{countryId}")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country,
			@PathVariable("countryId") int countryId) {
		service.updateCountry(country, countryId);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

	@DeleteMapping("/countries/{countryId}")
	public ResponseEntity<String> deleteCountry(@PathVariable("countryId") int countryId){
		service.deleteCountry(countryId);
		return new ResponseEntity<String>("Country with Id "+countryId+ "deleted",HttpStatus.OK);
	}
}
