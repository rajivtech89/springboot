package com.rajiv.usermanagement.service.impl;

import java.util.List;
import java.util.Optional;

import com.rajiv.usermanagement.dto.Users;
import com.rajiv.usermanagement.repo.UserRepository;
import com.rajiv.usermanagement.service.UserService;

public class UserServiceImpl implements UserService {

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
		userToUpdate.setName(user.getName());
		userToUpdate.setAddress(user.getAddress());

		return userToUpdate;

	}

	@Override
	public String delete(Integer userId) {
		
		repo.deleteById(userId);
		return "User Deleted";
	}

}
