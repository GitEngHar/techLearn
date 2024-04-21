import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {
        callbackSample ();
    }
    public static void callbackSample(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        AsyncProcess proc = new AsyncProcess(
            new AsyncCallback() {
                public void notify(String message){
                    System.out.println("callback message" + message);
                    executor.shutdown();
                }
        });
        executor.execute(proc);
        System.out.println("AsyncProcess is started.");
    }
    public static void execLongHolder(){
        LongHolder holder = new LongHolder();
        Thread th1 = new Thread(new LongPlusSetter("thread1", holder));
        Thread th2 = new Thread(new LongMinusSetter("thread2", holder));
        th1.start();
        th2.start();
        try{
            th1.join();
            th2.join();
            long result = holder.getResult();
            System.out.printf("result:%d",result);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void execIncrement(){
        HolderInt holder = new HolderInt();
        Thread th1 = new Thread(new Incrementer("thread1", holder));
        Thread th2 = new Thread(new Incrementer("thread2", holder));
        th1.start();
        th2.start();
        try{
            th1.join();
            th2.join();
            int result = holder.getNum();
            System.out.printf("result:%d",result);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        

    }
    public void runDeadLock(){
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("list1-1");
        list2.add("list2-1");

        new Thread(new ResourceLock("Thread A", list1, list2)).start();
        new Thread(new ResourceLock("Thread B", list2, list1)).start();
    }
}
