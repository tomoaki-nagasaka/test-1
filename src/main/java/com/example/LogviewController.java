package com.example;

@Controller
public class LogviewController {

	@RequestMapping("/logview")
	String logview() {
		return "logview";
	}

}