package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdata")
public class User {

	@Id
    private String custid;
    private String username;
    private String orgname;
    private String password;
    //private String role;

    public User() {
    }

    public String getCustid() {
        return custid;
    }

    public void setCustId(String userid) {
        this.custid = custid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}