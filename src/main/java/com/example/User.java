package net.teachingprogramming.mybootapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdata")
public class User {

	@Id
	@Setter
	@Getter
    private String custid;


    @Setter
    @Getter
    private String username;


    @Getter
    @Setter
    private String orgname;


    @Getter
    @Setter
    private String password;


    //@Getter
    //@Setter
    //private String role;
}