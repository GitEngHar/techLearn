package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloBean;

@RestController
@RequestMapping("/")
public class TestController {
	@Autowired
	HelloBean helloBean;
	@GetMapping("wp")
	public String rootHandler() {
		helloBean.hello();
		return "OK";
	}
}
