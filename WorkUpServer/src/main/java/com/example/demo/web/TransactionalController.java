package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TransactionalService;

@RestController
@RequestMapping("/tran")
public class TransactionalController {
	// ComponentでBean化した HelloBean をDIする
	@Autowired
	TransactionalService transactionalService;

	/* 交換処理 */
	@GetMapping("")
	public String rootHandler() {
		try {
			transactionalService.exchangePointToItem();
			System.out.println(transactionalService.getGamePoint());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "NG";
		}
		return "OK";
	}
	
	/* ポイントリセット */
	@GetMapping("reset")
	public String resetHandler() {
		try {
			transactionalService.resetPoint();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "NG";
		}
		return "OK";	
	}

}
