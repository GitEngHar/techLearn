import java.util.Calendar;
import java.util.Date;
public class App {
    public static void main(String[] args) throws Exception {
        Date now = new Date(); //Data型で機械嬉しい
        System.out.println(now);

        Calendar c = Calendar.getInstance();
        c.setTime(now); //Data型
        int y = c.get(Calendar.YEAR); //分離するint型
        c.set(2023,8,22,1,23,45);
        c.set(Calendar.YEAR,2011);
        Date past = c.getTime();
        System.out.println(past);
    }
}
