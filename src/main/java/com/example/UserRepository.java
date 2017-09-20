package com.example;

import com.example.userdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


	public interface UserRepository extends JpaRepository<userdata, String>{
	}


