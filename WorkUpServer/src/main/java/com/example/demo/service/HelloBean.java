package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	@Value("${beanTestValue.value}")
	private String beanTestValue;
	
	public String confirmBeanTestValue() {
		System.out.println("DiValue=" + beanTestValue);
		return beanTestValue;
	}
	
	public void hello() {
		System.out.println("helloBean");
	}
}
