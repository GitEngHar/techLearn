package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JqueryEntity;
import com.example.demo.repository.JqueryRepository;

@Service
public class JqueryService {
	@Autowired
	private JqueryRepository jqueryRepository;
	
	public JqueryEntity getjqData(int id) {
		return jqueryRepository.getjqData(id);
	}
}
