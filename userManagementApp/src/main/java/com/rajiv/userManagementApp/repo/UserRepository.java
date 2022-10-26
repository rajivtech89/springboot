package com.rajiv.userManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajiv.userManagementApp.dto.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
