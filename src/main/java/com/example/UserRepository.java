package com.example;

import com.example.userdata;
import com.example.WebSecurityConfig;
import com.example.Main;
import org.springframework.data.jpa.repository.JpaRepository;


	public interface UserRepository extends JpaRepository<userdata, String>{
	}


