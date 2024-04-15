import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataCalenderExit {
    public void ex1(){
        Date now = new Date();
        System.out.println(now);
    }   
    public void ex2(){
        Date old = new Date(5000);
        System.out.println(old);
    }
    public void ex3(){
       Calendar cl = Calendar.getInstance();
       System.out.println(cl.getTime());  
    }

    public void ex4(){
        Calendar cl = Calendar.getInstance();
        Date dt = cl.getTime();
        System.out.println(dt);  
    }

    public void ex5(){
        Calendar cl = Calendar.getInstance();
        Date dt = new Date(cl.getTimeInMillis());
        System.out.println(dt);  
    }

    public void ex6(){
        Date dt = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dt);
        System.out.println(cl.getTime());
    }
    
    public void ex7(){
        Date dt = new Date();
        DateFormat format = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 時 mm 分 ss 秒");
        System.out.println(format.format(dt));
    }

    
}
