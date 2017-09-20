package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.example.userdata;
import com.example.UserRepository;
import com.example.WebSecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Autowired
private UserRepository userRepository;
@Autowired
private AuthorityRepository authorityRepository;

@RequestMapping(value = "signup", method = RequestMethod.GET)
public String signup() {
    return "signup";
}

@RequestMapping(value = "signup", method = RequestMethod.POST)
public String signup(@RequestParam String custid,@RequestParam String username,@RequestParam String orgname,@RequestParam String password) {
    userdata user = new User();
    user.setCustid(custid);
    user.setUsername(username);
    user.setOrgname(orgname);
    user.setPassword(password);
    userRepository.save(user);

    return "signup";
}

@Bean
public DataSource dataSource() throws SQLException {
	if (dbUrl == null || dbUrl.isEmpty()) {
		return new HikariDataSource();
	} else {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		return new HikariDataSource(config);
	}

