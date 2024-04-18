import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        execIncrement();
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
