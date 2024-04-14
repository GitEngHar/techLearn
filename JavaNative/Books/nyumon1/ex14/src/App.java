import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class App {
    public static void main(String[] args) throws Exception {
        Date now = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(now);
        int day = cl.get(Calendar.DAY_OF_MONTH);
        cl.set(Calendar.DAY_OF_MONTH,day);
        Date date = cl.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日");
        System.out.println(sdf.format(date));

    }
}
