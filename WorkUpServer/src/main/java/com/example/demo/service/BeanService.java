package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.domain.TestBean;
import com.example.demo.repository.TestBeanRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Service
public class BeanService {
	private final TestBeanRepository testBeanRepository;
	public TestBean getTestBeanById() {
		int testBeanId = 1;
		return testBeanRepository.selectTestBean(testBeanId);
	}
}
