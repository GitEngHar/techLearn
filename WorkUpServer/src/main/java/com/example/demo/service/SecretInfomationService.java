package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.domain.SecretInfomation;
import com.example.demo.repository.SecretInfomationRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
@Service
public class SecretInfomationService {
	private final SecretInfomationRepository secretInfomationRepository;
	
	
	public SecretInfomation getSecretInfo() {
		return secretInfomationRepository.selectInfomationById(1);
	}
	
	
}
