package com.example;

import com.example.User;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface UserRepository extends JpaRepository<User, String>{
	}


