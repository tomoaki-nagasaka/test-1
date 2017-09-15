//package net.teachingprogramming.mybootapp.entity;

import net.teachingprogramming.mybootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
}
