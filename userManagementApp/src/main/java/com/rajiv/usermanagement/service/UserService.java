package com.rajiv.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajiv.usermanagement.dto.Users;

@Service
public interface UserService {

	List<Users> getAllUsers();

	Users getUser(int id);

	Users save(Users user);

	Users update(Users userToUpdate, Integer userId);

	String delete(Integer userId);

}
