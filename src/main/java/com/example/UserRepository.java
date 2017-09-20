package com.example;

import com.example.userdata;
import org.springframework.data.jpa.JpaRepository;
//.repository



	public interface UserRepository extends JpaRepository<userdata, String>{
	}


