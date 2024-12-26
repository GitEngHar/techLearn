package com.example.demo.helper;
import com.example.demo.domain.ThreadCounter;

public class ThreadCounterHelper extends Thread {
    // counterオブジェクト
    private final ThreadCounter threadCounter;
    public ThreadCounterHelper(
            ThreadCounter threadCounter
    ){
        this.threadCounter = threadCounter;
    }
    // Threadで処理させたいcounter加算メソッド
    public void run(){
        for(int i=0;i<1000;i++){
            threadCounter.increment();
        }
    }
}
