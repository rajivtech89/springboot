package com.rajiv.userManagementApp.api;

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

import com.rajiv.userManagementApp.dto.Users;
import com.rajiv.userManagementApp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsers() {
		return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUser(@PathVariable int id) {
		return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable("id") Integer userId) {
		return new ResponseEntity<>(service.update(user, userId), HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId) {
		return new ResponseEntity<>(service.delete(userId), HttpStatus.OK);
	}
}
