package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	@Value("${beanTestValue.value}")
	private String beanTestValue;
	
	public String confirmBeanTestValue() {
		return beanTestValue;
	}
}
