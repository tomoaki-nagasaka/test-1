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

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Controller
@SpringBootApplication
public class LogviewController {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired
	private DataSource dataSource;

	@RequestMapping("/logview")
	String logview(Model model) {
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM botlog ORDER BY NO");

			HashMap map = new HashMap();
			ArrayList<test> output = new ArrayList<test>();

			while (rs.next()) {
				test bte = new test();
				bte.setNo(Integer.parseInt(rs.getString("NO")));
				bte.setTime(rs.getString("TIME"));
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

	public class test {
		private int no;
		private String time;
		private String userid;
		private String contents;
		private String returnd;

		public void setNo(int no) {
			this.no = no;
		}

		public int getNo() {
			return no;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getTime() {
			return time;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getUserid() {
			return userid;
		}

		public void setContents(String contents) {
			this.contents = contents;
		}

		public String getContents() {
			return contents;
		}

		public void setReturnd(String returnd) {
			this.returnd = returnd;
		}

		public String getReturnd() {
			return returnd;
		}

	}

}