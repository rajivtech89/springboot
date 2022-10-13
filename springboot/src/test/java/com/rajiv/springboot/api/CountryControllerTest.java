package com.rajiv.springboot.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.serviceimpl.CountryServiceImpl;

@SpringBootTest
class CountryControllerTest {

	@Mock
	CountryServiceImpl service;

	@InjectMocks
	CountryController contoller;

	public static List<Country> myCountries = new ArrayList<>();

	@BeforeAll
	public static void setup() {

		myCountries.add(new Country(1, "India", "Delhi"));
		myCountries.add(new Country(2, "USA", "Washington"));
		myCountries.add(new Country(3, "Australia", "Melbouren"));
		myCountries.add(new Country(4, "Canada", "Torento"));
	}

	@Test
	public void test_getAllCountries() {
		when(service.getAllCountries()).thenReturn(myCountries); // mocking
		ResponseEntity<List<Country>> respone = contoller.getCountries();
		assertEquals(HttpStatus.OK, respone.getStatusCode());
		assertEquals(4, respone.getBody().size());
	}

	@Test
	public void test_getCountryById() {
		Country country = new Country(1, "India", "Delhi");
		when(service.getCountryById(1)).thenReturn(country); // mocking
		ResponseEntity<Country> respone = contoller.getCountrById(1);
		assertEquals(HttpStatus.OK, respone.getStatusCode());
		assertEquals(1, respone.getBody().getId());
	}

	@Test
	public void test_addCountry() {
		Country country = new Country(1, "India", "Delhi");
		when(service.addCountry(country)).thenReturn(country); // mocking
		ResponseEntity<Country> respone = contoller.addCountry(country);
		assertEquals(HttpStatus.CREATED, respone.getStatusCode());
		assertEquals(country, respone.getBody());
	}

	@Test
	public void test_updateCountry() {
		Country country = new Country(1, "India", "Delhi");
		ResponseEntity<Country> respone = contoller.updateCountry(country, 1);
		assertEquals(HttpStatus.OK, respone.getStatusCode());
		assertEquals(country, respone.getBody());
	}

}
