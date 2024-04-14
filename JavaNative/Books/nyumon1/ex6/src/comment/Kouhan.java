package comment;
import comment.Zenhan;
import java.lang.Thread.*;
public class Kouhan {
    public static void doDeae(){
        System.out.println("ええい。こしゃくなであえ！");
    }
    public static void showMondokoro(){
        System.out.println("この紋所がめにはいらぬか");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Zenhan.dotogame();
    }
}
