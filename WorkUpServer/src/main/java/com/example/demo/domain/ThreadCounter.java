package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class ThreadCounter {
    // アクセス対象のカウント変数
    int count = 0;

    // 同期させたいカウントアップ処理
    public synchronized void syncIncrement(){
        this.count++;
    }

    // 同期させたいカウント取得処理
    public synchronized int syncGetCount(){
        return this.count;
    }
    public void init(){
        this.count = 0;
    }
    // 同期させたくないカウントアップ処理
    public void notSyncIncrement(){
        this.count++;
    }

    // 同期させたくないカウント取得処理
    public int notSyncGetCount(){
        return this.count;
    }
}