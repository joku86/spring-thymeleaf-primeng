package de.jk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import de.jk.model.Employee;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String home1( Model model) {
		model.addAttribute("totalArticles", 7);
		return "home";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/403")
	public String error403() {
		return "error/403";
	}

}
