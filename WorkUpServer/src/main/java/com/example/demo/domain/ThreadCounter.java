package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class ThreadCounter {
    // アクセス対象のカウント変数
    int count = 0;

    // 同期させたいカウントアップ処理
    public synchronized void increment(){
        this.count++;
    }

    // 同期させたいカウント取得処理
    public synchronized int getCount(){
        return this.count;
    }
}