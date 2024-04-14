import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class exTest1 {
    public String getValueFromFile(File file) throws IOException{
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get(file.getPath())));
        String value = props.getProperty("key");
        return value;
    }
    public void exits(){
        byte[] contents = new byte[100];
        Path path = Paths.get("C:\\Users\\杉山聖哉\\Documents\\java\\Books\\exception\\exception\\src\\hello.txt");
        File file = new File("C:\\Users\\杉山聖哉\\Documents\\java\\Books\\exception\\exception\\src\\hello.txt");
        
        exTest1 extest1 = new exTest1();
        
        try{     
            System.out.println("value=" + extest1.getValueFromFile(file));
        } catch(IOException ex){

        }
    }
}
