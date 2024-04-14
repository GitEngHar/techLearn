import java.io.*;
import java.net.URL;
public class App {
    public static void main(String[] args) throws Exception {
        String filename = "./test.txt";
        fwrites(filename);
    }
    public static void fwrites(String filename) throws Exception{
        FileWriter fr = new FileWriter(filename);
        fr.write("test1 ");
        fr.write("test2 ");
        fr.close();
    }
    public static void fread(String filename) throws Exception{
        FileReader fr = new FileReader(filename);
        char c1 = (char)fr.read();
        char c2 = (char)fr.read();
        fr.close();
        System.out.println(c1);
        System.out.println(c2);
    
    }
}
