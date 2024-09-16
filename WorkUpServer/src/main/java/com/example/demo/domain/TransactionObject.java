package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionObject {
	private int transactionalId;
	private int userId;
	private int changePoint;
	private String description;
}
