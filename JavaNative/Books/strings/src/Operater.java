import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operater {
    String str1 = "";
    String str2 = "";
    String sentence = "This is a pen.";
    Operater(String str1 , String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
    public void exit(){
        test7();
    }
    public void test1(){
        System.out.println(str1 + str2);// + で結合する例
        System.out.println(str1.concat(str2));// concatで結合する例
        StringBuilder builder = new StringBuilder(str1);
        builder.append(str2);
        System.out.println(builder.toString());
        // StringBuilderで結合する例
    }
    public void test2(){
        
        int index = sentence.indexOf("is",3);
        int lastIndex = sentence.lastIndexOf("is");
        System.out.println(lastIndex); 
    }
    public void test3(){
        Pattern emptyPattern = Pattern.compile("\\s+");
        this.sentence = "This        is a pen"; 
        String [] words = emptyPattern.split(sentence); 
        for (String word : words){
            System.out.println(word);
        }
    }
    public void test4(){
        Pattern pattern = Pattern.compile("This is a .*\\.");
        
        Matcher matcher = pattern.matcher(sentence);
        if(matcher.matches()){
            System.out.println("OK");
        }else{
            System.out.println("No");
        }
    }    
    public void test5(){
        Pattern emptyPattern = Pattern.compile("\\s+");
        this.sentence = "This        is a   pen"; 
        Matcher matcher = emptyPattern.matcher(sentence); 
        System.out.println(matcher.replaceAll(" "));
    }
    public void test6(){
        System.out.println("--judge--");
        System.out.println(sentence.matches("Th.* is a .*\\."));
        System.out.println("---split---");
        String [] words = sentence.split("\\s+");
        for(String word:words){
            System.out.println(word);
        }
        System.out.println("---replace---");
        System.out.println(sentence.replaceAll("\\s+", "-"));
    }
    public void test7(){
        String message = MessageFormat.format("str1 : {0} str2 : {1}",str1,str2);
        System.out.println(message);
        int int1 = 1;
        System.out.printf("str1 : %s , str2 : %s , int1 : %d",str1,str2,int1);
    }
}
