package com.rajiv.springboot.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajiv.springboot.model.Country;
import com.rajiv.springboot.serviceimpl.CountryServiceImpl;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
public class CountryControllerMockMvcTest {

	@Autowired
	MockMvc mockMvc;

	@Mock
	CountryServiceImpl service;

	@InjectMocks
	CountryController controller;

	public static List<Country> myCountries = new ArrayList<>();

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		myCountries.add(new Country(1, "India", "Delhi"));
		myCountries.add(new Country(2, "USA", "Washington"));
		myCountries.add(new Country(3, "Australia", "Melbouren"));
		myCountries.add(new Country(4, "Canada", "Torento"));

	}

	@Test
	public void test_getCountries() throws Exception {
		when(service.getAllCountries()).thenReturn(myCountries);
		this.mockMvc.perform(get("/countries")).andExpect(status().is2xxSuccessful()).andDo(print());
	}

	@Test
	public void test_getCountryById() throws Exception {
		Country country = new Country(1, "India", "Delhi");
		when(service.getCountryById(1)).thenReturn(country);
		this.mockMvc.perform(get("/countries/{id}", 1)).andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath(".id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath(".countryName").value("India"))
				.andExpect(MockMvcResultMatchers.jsonPath(".countryCapital").value("Delhi")).andDo(print());
	}

	@Test
	public void test_addCountry() throws Exception {
		Country country = new Country(5, "India", "Delhi");
		when(service.addCountry(country)).thenReturn(country);
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(country);

		this.mockMvc.perform(post("/countries").content(jsonBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andDo(print());
	}

	@Test
	public void test_updateCountry() throws Exception {
		Country country = new Country(1, "India", "Delhi");
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(country);
		this.mockMvc.perform(put("/countries/{id}", "1").content(jsonBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void test_deleteCountry() throws Exception {
		this.mockMvc.perform(delete("/countries/{id}", "1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
