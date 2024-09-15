package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.GamePoint;
import com.example.demo.repository.GamePointRepository;
import com.example.demo.repository.TransactionalRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Service
public class TransactionalService {
	private final TransactionalRepository transactionalRepository;
	private final GamePointRepository gamePointRepository;
	private int breadStock = 2;
	private int appleStock = 1;
	// ゲームで買い物をしてポイントを減算する
	@Transactional(rollbackFor=Exception.class)
	public String exchangePointToItem() throws Exception {
		int userId = 1;
		int itemId = 1;
		int exhangeCost = 10;// 交換アイテムのコスト
		String wantItem = "";
		String description = "exchange point to item";
		// トランザクションテーブルへ追加
		transactionalRepository.insertTransactionObject(userId, exhangeCost, description);
			
		// 交換対象のアイテムを取得する
		wantItem = getItem(itemId);
		
		// ユーザーのポイントを減算する()
		gamePointRepository.exchangePointToItem(userId, exhangeCost);	
		return wantItem;
	}
	
	public void resetPoint() {
		int userId = 1;
		gamePointRepository.resetPoint(userId);
	}
	
	// アイテムIDからアイテムを取得する
	private String getItem(int itemId) throws Exception {
		String result = "";
		
		switch(itemId) {
			case 1:
				result = "bread";
				breadStock =breadStock - 1;	
				break;
			case 2:
				result = "apple";
				appleStock =appleStock - 1;
				break;
		}
		
		if(0 > breadStock || 0 > appleStock) {
			throw new Exception("No Stock Error");
		}
		
		return result;
	}
	
	public GamePoint getGamePoint() {
		return gamePointRepository.selectGamePoint(1);
	}
}
