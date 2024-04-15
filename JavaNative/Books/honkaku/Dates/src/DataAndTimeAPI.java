import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

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
    
    public void ex5(){
        String datetime = "2020-04-15T00:27:22.222";
        LocalDateTime ldt = LocalDateTime.parse(datetime);
        System.out.println("3 years >> : " + ldt.plusYears(3));
        System.out.println("6 days >> : " + ldt.plusDays(6));
        System.out.println("<< 6 days ago : " + ldt.minusDays(6));
    }

    public void ex6(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd/ HH:mm:ss.SSS").format(ldt));
    }

    public void ex7(){
        TemporalAccessor tma = DateTimeFormatter.ofPattern("yyyy/MM/dd/ HH:mm:ss.SSS").parse("2022/11/1 11:11:11.111");
        LocalDateTime ldt = LocalDateTime.from(tma);
        System.out.println(ldt);
    }

    public void ex8(){
        JapaneseDate date = JapaneseDate.of(2024,4,14);
        System.out.println(date);
    } 
}
