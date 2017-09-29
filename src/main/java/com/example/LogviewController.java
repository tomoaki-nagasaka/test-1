package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Controller
@SpringBootApplication
public class LogviewController {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired
	private DataSource dataSource;

	@RequestMapping(value = "/logview",method = RequestMethod.GET)
	String logview(Model model) {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM botlog ORDER BY NO");

			HashMap map = new HashMap();
			ArrayList<BotlogEntity> output = new ArrayList<BotlogEntity>();

			while (rs.next()) {
				BotlogEntity bte = new BotlogEntity();
				bte.setNo(Integer.parseInt(rs.getString("NO")));
				String time = rs.getString("TIME");
				bte.setTime(time.substring(0,4) + "/" + time.substring(4,6) + "/" + time.substring(6,8) + " " + time.substring(8,10) + ":" + time.substring(10,12));
				bte.setUserid(rs.getString("USERID"));
				bte.setContents(rs.getString("CONTENTS"));
				bte.setReturnd(rs.getString("RETURN"));
				output.add(bte);
			}

			/*
			while (rs.next()) {
				map.clear();
				map.put("NO", rs.getString("NO"));
				map.put("TIME", rs.getString("TIME"));
				map.put("USERID", rs.getString("USERID"));
				map.put("CONTENTS", rs.getString("CONTENTS"));
				map.put("RETURN", rs.getString("RETURN"));
				output.add(map);
			}
			*/


			model.addAttribute("records", output);
			return "logview";
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		//model.addAttribute("message", "テストですよ");
		//return "logview";
	}

	@RequestMapping(value = "/logview", params = "abc" , method = RequestMethod.POST)
	String post() {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★きたよ★★★★★★★★★★★★★★★★★★★★★★★★★");
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