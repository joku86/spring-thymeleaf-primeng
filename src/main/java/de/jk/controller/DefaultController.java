package de.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {


	@RequestMapping("/")
	public String home1( Model model) {
		model.addAttribute("totalArticles", 7);
		return "home";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/403")
	public String error403() {
		return "error/403";
	}

}
