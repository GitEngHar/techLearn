package com.example.demo.web;

import com.example.demo.domain.ThreadCounter;
import com.example.demo.helper.ThreadCounterHelper;
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

        for(int i=0;i<100;i++){
            ThreadCounterHelper threadCounterHelper = new ThreadCounterHelper(threadCounter);
            threadCounterHelper.start();
        }

        try{
            Thread.sleep(2000);
            count = threadCounter.getCount();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        model.addAttribute("count",count);
        return "/thread-counter";
    }

    /*
     * スレッドセーフの場合で数値加算をする
     * */
    @GetMapping("thread-no-safe")
    private String threadNoSafe(){
        return "/thread-counter";
    }
}
