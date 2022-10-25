package com.rajiv.usermanagement.api;

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

import com.rajiv.usermanagement.dto.Users;
import com.rajiv.usermanagement.service.UserService;

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

	@PutMapping("/users")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Integer userId) {
		return new ResponseEntity<>(service.update(user, userId), HttpStatus.OK);
	}

	@DeleteMapping("/users")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
		return new ResponseEntity<>(service.delete(userId), HttpStatus.OK);
	}
}
