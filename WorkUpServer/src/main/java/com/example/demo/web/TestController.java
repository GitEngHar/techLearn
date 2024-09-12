package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
	@GetMapping("wp")
	public String rootHandler() {
		System.out.println("OK");
		return "OK";
	}
}
