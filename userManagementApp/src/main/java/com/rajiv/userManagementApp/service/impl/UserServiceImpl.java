package com.rajiv.userManagementApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajiv.userManagementApp.dto.Users;
import com.rajiv.userManagementApp.repo.UserRepository;
import com.rajiv.userManagementApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<Users> getAllUsers() {

		return repo.findAll();
	}

	@Override
	public Users getUser(int id) {

		Optional<Users> user = repo.findById(id);
		if (user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public Users save(Users user) {

		return repo.save(user);
	}

	@Override
	public Users update(Users userToUpdate, Integer userId) {
		Optional<Users> userOptional = repo.findById(userId);
		Users user = null;
		user = userOptional.get();
		user.setName(userToUpdate.getName());
		user.setAddress(userToUpdate.getAddress());
		repo.save(user);
		return user;

	}

	@Override
	public String delete(Integer userId) {
		
		repo.deleteById(userId);
		return "User Deleted";
	}

}
