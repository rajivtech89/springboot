package com.rajiv.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajiv.usermanagement.dto.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
