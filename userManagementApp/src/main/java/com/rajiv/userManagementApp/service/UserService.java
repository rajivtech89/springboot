package com.rajiv.userManagementApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajiv.userManagementApp.dto.Users;


public interface UserService {

	List<Users> getAllUsers();

	Users getUser(int id);

	Users save(Users user);

	Users update(Users userToUpdate, Integer userId);

	String delete(Integer userId);

}
