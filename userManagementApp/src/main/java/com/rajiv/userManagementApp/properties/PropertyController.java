package com.rajiv.userManagementApp.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

	@Autowired
	private User user;
	
	@GetMapping("/property")
	public String getProperty() {
		return user.toString();
	}
}
