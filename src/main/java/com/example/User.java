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

    @Id
    @Setter
    @Getter
    private String username;

    @Id
    @Getter
    @Setter
    private String orgname;

    @Id
    @Getter
    @Setter
    private String password;

    @Id
    @Getter
    @Setter
    private String role;
}