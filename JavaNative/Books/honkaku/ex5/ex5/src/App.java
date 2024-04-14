import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        // IntStream stiny = IntStream.rangeClosed(1, 5);
        // stiny.forEach(i -> System.out.println(i));
        //ex1();
        //oneOfStream();
        //streamEndExitJoining();
        //streamEndExitGrouping();
        //stremaEndExitElement();
        //streamOftenUse();
        listOftenUse();
    }
    public static void ex1(){
        List<Student> student = new ArrayList<Student>();// student型のArrayを作成
        student.add(new Student(70,"haru"));
        student.add(new Student(75,"eri"));
        student.add(new Student(80,"mako"));
        Stream<Integer> stream = student.stream().map(s -> s.getScore());
        stream.forEach(System.out::println);//scoreの取り出し
    } 
    public static void oneOfStream(){
        List<Group> groups = new ArrayList<Group>();
        Group group1 = new Group();
        group1.add(new Student(80,"haru1"));
        group1.add(new Student(85,"haru1"));
        group1.add(new Student(90,"haru1"));
        groups.add(group1);
        Group group2 = new Group();
        group2.add(new Student(70,"erina1"));
        group2.add(new Student(75,"erina1"));
        group2.add(new Student(80,"erina1"));
        groups.add(group2);
        Group group3 = new Group();
        group3.add(new Student(60,"mako1"));
        group3.add(new Student(65,"mako1"));
        group3.add(new Student(70,"mako1"));
        groups.add(group3);
        
        Stream<List<Student>> mappedStream = groups.stream().map(g -> g.getStudent());//配列が別
        Stream<Student> flatMappedStream = groups.stream().flatMap(g -> g.getStudent().stream());//配列の結合が必要ない
        Stream<String> studentNames = flatMappedStream.map(s -> s.getName());
        /*mappedStream.forEach(
            s -> s.forEach(
                ss -> System.out.println(
                    ss.getName()
                    )
                )
            );*/
        /*flatMappedStream.limit(2).forEach(
            s -> System.out.println(
                s.getName()
            )
        );
        */
        studentNames.distinct().forEach(
            System.out::println
        );
        
    }

    public static void streamEndExitJoining(){
        List<String> list = Arrays.asList("Kimura","Takahasi","Murata");// List 宣言
        String joined = list.stream().
        filter(l -> l.length() > 5).// 文字列が5以上でフィルタする
        collect(Collectors.joining(","));// 文字列を結合する
        System.out.println(joined);
    }

    public static void streamEndExitGrouping(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(100,"Kimura"));
        students.add(new Student(90,"Takahashi"));
        students.add(new Student(100,"Murata"));

        Map<Integer,List<Student>> map = students.stream()
            .collect(Collectors.groupingBy(Student::getScore));
        List<Student> perfect = map.get(100);
        perfect.forEach(s -> System.out.println(s.getName())); 
        
    }

    public static void stremaEndExitElement(){
        List<Integer> numsArray = new ArrayList<Integer>();
        int[] nums = {1,2,3,4,5}; 
        numsArray.add(100);
        numsArray.add(200);
        numsArray.add(20);
        numsArray.add(400);
        IntStream summary = IntStream.of(nums);
        Optional minValue = numsArray.stream().min(Comparator.naturalOrder());
        Optional maxValue = numsArray.stream().max(Comparator.naturalOrder());
        long arrayElementNum = numsArray.stream().count();
        OptionalDouble aveValue = summary.average();
        System.out.println(aveValue.getAsDouble()); 
    }

    public static void streamOftenUse(){
        List<String> baseList = Arrays.asList("12345","123456","1234567");
        /*
         List<String> newList = baseList.stream()
        .filter(s -> s.length()>6)
        .map(s -> s + "," )
        .collect(Collectors.toList());
         */
        Stream<String> newList = baseList.stream()
        .filter(s -> s.length()>5);
        List<String> newsList = newList.collect(Collectors.toList());

        newsList.forEach(System.out::println);
    }

    public static void listOftenUse(){
        List<String> baseList = Arrays.asList("12345","123456","1234567");
        baseList.removeIf(s -> 5 > s.length() );
        baseList.stream().forEach(System.out::println);

        List<String> baseList2 = Arrays.asList("Abcd","efg","hijk");
        baseList2.replaceAll(s -> s.toUpperCase());

        baseList2.forEach(System.out::println);
                String item = "+" + "aaaaa" + "+";
        List<String> itemLists= Arrays.asList(item);
        int strLength = item.length();
        String output = IntStream.range(0,strLength)
        .mapToObj(i -> "+")
        .collect(Collectors.joining(","));
    } 
    //文字列を
    //文字列の長さを取得
    //IntStreamで文字列分の*を作成
    //出力
}