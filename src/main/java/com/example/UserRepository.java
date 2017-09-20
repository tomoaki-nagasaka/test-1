package com.example;

import com.example.userdata;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface UserRepository extends JpaRepository<User, String>{
	}


