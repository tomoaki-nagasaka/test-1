package net.teachingprogramming.mybootapp.repository;

import net.teachingprogramming.mybootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface userRepository extends JpaRepository<User, String>{
	}


