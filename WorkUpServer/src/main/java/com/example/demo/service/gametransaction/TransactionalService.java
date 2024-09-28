package com.example.demo.service.gametransaction;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.GamePoint;
import com.example.demo.repository.gametransaction.GamePointRepository;
import com.example.demo.repository.gametransaction.TransactionalRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Service
@Data
public class TransactionalService {
	private final TransactionalRepository transactionalRepository;
	private final GamePointRepository gamePointRepository;
	private int breadStock = 2;
	private int appleStock = 2;
	// ゲームで買い物をしてポイントを減算する。
	@Transactional(rollbackFor=Exception.class)
	public void exchangePointToItem() throws Exception {
		int userId = 1;
		int itemId = 1;
		int exhangeCost = 10;// 交換アイテムのコスト
		String description = "exchange point to item";
		
		// トランザクションテーブルへ追加
		transactionalRepository.insertTransactionObject(userId, exhangeCost, description);
			
		// アイテムの在庫を減らす
		minusItemStock(itemId);
		
		// ユーザーのポイントを減算する
		gamePointRepository.exchangePointToItem(userId, exhangeCost);	

	}
	
	// 検証に利用するポイントをリセットする
	public void resetPoint() {
		int userId = 1;
		gamePointRepository.resetPoint(userId);
	}
	
	// アイテムIDからアイテムを取得する
	protected void minusItemStock(int itemId) throws Exception {
		switch(itemId) {
			case 1:
				breadStock =breadStock - 1;	
				break;
			case 2:
				appleStock =appleStock - 1;
				break;
		}
		
		if(0 > breadStock || 0 > appleStock) {
			throw new Exception("No Stock Error");
		}

	}
	
	public GamePoint getGamePoint() {
		return gamePointRepository.selectGamePoint(1);
	}
}
