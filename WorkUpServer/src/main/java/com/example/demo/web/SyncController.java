package com.example.demo.web;

import com.example.demo.domain.ThreadCounter;
import com.example.demo.helper.ThreadCounterNotSyncHelper;
import com.example.demo.helper.ThreadCounterSyncHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/sync/")
public class SyncController {
    @Autowired
    ThreadCounter threadCounter;
    /*
    * スレッドセーフの場合で数値加算をする
    * */
    @GetMapping("thread-safe")
    private String threadSafe(Model model){
        int count = 0;
        // カウントをリセットする
        threadCounter.init();
        // 100 Thread を同期して実行する
        for(int i=0;i<1000;i++){
            ThreadCounterSyncHelper threadCounterHelper = new ThreadCounterSyncHelper(threadCounter);
            threadCounterHelper.start();
        }
        try{
            // 5秒まつ
            Thread.sleep(5000);
            // 結果の取得
            count = threadCounter.syncGetCount();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // 結果表示
        model.addAttribute("count",count);
        return "/thread-counter";
    }

    /*
     * スレッドセーフをしない場合で数値加算をする
     * */
    @GetMapping("thread-no-safe")
    private String threadNoSafe(Model model){
        int count = 0;
        // カウントをリセットする
        threadCounter.init();
        // 100 Thread を非同期で実行する
        for(int i=0;i<1000;i++){
            ThreadCounterNotSyncHelper threadCounterHelper = new ThreadCounterNotSyncHelper(threadCounter);
            threadCounterHelper.start();
        }
        try{
            // 5秒まつ
            Thread.sleep(5000);
            // 結果の取得
            count = threadCounter.notSyncGetCount();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // 結果表示
        model.addAttribute("count",count);
        return "/thread-counter";
    }
}
