package com.rajiv.springboot;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/users")
	public String getUsers() {
		return "http get method";
	}

	@GetMapping(value = "/usersparam")
	public ResponseEntity getUsersParam(@RequestParam Map<String, String> params) {
		System.out.println(params.keySet());
		System.out.println(params.values());
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	@GetMapping(value = "/users/{id}")
	public String getUsers(@PathVariable String id) {
		return "http get method with id " + id;
	}

	@PostMapping("/users")
	public String createUser() {
		return "http post method";
	}

	@PutMapping("/users")
	public String updatetUser() {
		return "http put method";
	}

	@DeleteMapping("/users")
	public String deleteUsers() {
		return "http delete method";
	}

}
