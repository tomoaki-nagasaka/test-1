package com.example;

import net.teachingprogramming.mybootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository{
	public interface UserRepository extends JpaRepository<User, String>{
	}

}
