import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            throw new TypeException("happned ..myError");
            // FileWriter fi = new FileWriter("data.txt");
            // fi.write("hello");
            // int a = 0/0;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
