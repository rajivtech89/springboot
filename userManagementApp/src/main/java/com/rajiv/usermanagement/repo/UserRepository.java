package com.rajiv.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajiv.usermanagement.dto.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
