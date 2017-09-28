package com.example;

@Controller
public class LogviewController {

	@RequestMapping("/logview")
	String logview(Model model) {
		model.addAttribute("message", "テストですよ");
		return "logview";
	}

}