package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class LogviewController {

	@RequestMapping("/logview")
	String logview(Model model) {
		model.addAttribute("message", "テストですよ");
		return "logview";
	}

}