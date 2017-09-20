package com.example;

import com.example.userdata;
import org.springframework.data.jpa.repository.JpaRepository;


	@Repository
	public interface UserRepository extends JpaRepository<userdata, String>{
	}


