import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DataAndTimeAPI {
    public void ex1(){
        LocalDate ld = LocalDate.now();
        System.out.println("LocalDate : " + ld);

        LocalTime lt = LocalTime.now();
        System.out.println("LocalTime : " + lt);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("LocalDataTime : " + ldt);
    }

    public void ex2(){
        LocalDateTime ldt = LocalDateTime.of(2024,Month.APRIL,1,1,1,1);
        System.out.println(ldt);
    }

    public void ex3(){
        String datetime = "2020-04-15T00:27:22.222";
        LocalDateTime ldt = LocalDateTime.parse(datetime);
        System.out.println(ldt);
    }

    public void ex4(){
        String datetime = "2020-04-15T00:27:22.222";
        LocalDateTime ldt = LocalDateTime.parse(datetime);
        System.out.println("Year : " + ldt.getYear());
        System.out.println("Month : " + ldt.getMonth());
        System.out.println("Day : " + ldt.getDayOfMonth());
    }
    
}
