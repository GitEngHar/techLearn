package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestSecurityController {
	@GetMapping("")
	public String indexHandler() {
		return "top";
	}
	
	@GetMapping("hogepage")
	public String hogePageHandler() {
		return "hoge";
	}
	
	@GetMapping("adminpage")
	public String adminPageHandler() {
		return "admin";
	}
	
}
