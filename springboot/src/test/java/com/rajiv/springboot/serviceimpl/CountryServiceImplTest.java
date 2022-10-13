package com.rajiv.springboot.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.repositoryimpl.CountryRepoImpl;

@SpringBootTest
class CountryServiceImplTest {

	@Mock
	CountryRepoImpl repo;

	@InjectMocks
	CountryServiceImpl service;
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
		// when(actual_method).thenReturn(mock_data)
		when(repo.getAllCountries()).thenReturn(myCountries); // mocking
		assertEquals(4, service.getAllCountries().size());
	}
	
	@Test
	public void test_getCountryById() {
		when(repo.getCountryById(1)).thenReturn(new Country(1, "India", "Delhi"));
		assertEquals(1,service.getCountryById(1).getId());
	}
	
	@Test
	public void test_addCountry() {
		Country country = new Country(1, "India", "Delhi");
		when(repo.addCountry(country)).thenReturn(country);
		assertEquals(country,service.addCountry(country));
	}
	
	@Test
	public void test_updateCountry() {
		Country country = new Country(1, "India", "Delhi");
		service.updateCountry(country,1);
		verify(repo, times(1)).updateCountry(country,1);
	}

}
