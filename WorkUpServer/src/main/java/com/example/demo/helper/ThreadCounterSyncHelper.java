package com.example.demo.helper;
import com.example.demo.domain.ThreadCounter;

public class ThreadCounterSyncHelper extends Thread {
    // counterオブジェクト
    private final ThreadCounter threadCounter;
    public ThreadCounterSyncHelper(
            ThreadCounter threadCounter
    ){
        this.threadCounter = threadCounter;
    }
    // Threadで処理させたいcounter加算メソッド
    public void run(){
        for(int i=0;i<10000;i++){
            threadCounter.syncIncrement();
        }
    }
}
