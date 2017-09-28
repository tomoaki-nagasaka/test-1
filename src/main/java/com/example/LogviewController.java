package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Controller
@SpringBootApplication
public class LogviewController {

	@RequestMapping("/logview")
	String logview(Model model) {
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM botlog ORDER BY NO");

			HashMap map = new HashMap();
			ArrayList output = new ArrayList();
			while (rs.next()) {
				map.clear();
				map.put("NO", rs.getString("NO"));
				map.put("TIME", rs.getString("TIME"));
				map.put("USERID", rs.getString("USERID"));
				map.put("CONTENTS", rs.getString("CONTENTS"));
				map.put("RETURN", rs.getString("RETURN"));
				output.add(map);
			}

			model.put("records", output);
			return "logview";
		} catch (Exception e) {
			model.put("message", e.getMessage());
			return "error";
		}
		//model.addAttribute("message", "テストですよ");
		return "logview";
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
	}

}