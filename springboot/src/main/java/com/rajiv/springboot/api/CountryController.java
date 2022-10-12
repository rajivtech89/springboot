package com.rajiv.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService service;

	@GetMapping("/countries")
	public ResponseEntity<Country> getCountries() {
		return new ResponseEntity(service.getAllCountries(), HttpStatus.OK);
	}

}
