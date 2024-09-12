package com.example.demo.domain;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
	// cache のフィールド宣言
	private final Map<String, String> cache = new HashMap<>();
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    
    // キャッシュから値を獲得するメソッド
    public String get(String key) { 
    	readLock.lock();
    	try {
    		// キャッシュから値を取得する
    		return cache.get(key);
    	}finally {
    		// キャッシュをアンロックする
    		readLock.unlock();
    	}
    }
    
    // キャッシュに値を追加する設定
    public String put(String key,String value) {
    	writeLock.lock();
    	try {
    		// キャッシュに値をputする
    		return cache.put(key, value);
    	}finally {
    		// ロックを解除
    		writeLock.unlock();
    	}
    }
    
    // キャッシュの値を削除
    public void remove(String key) {
    	writeLock.lock();
    	try {
    		// キャッシュに値をputする
    		cache.remove(key);
    	}finally {
    		// ロックを解除
    		writeLock.unlock();
    	}
    }
}
