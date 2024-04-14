import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

public class FileType {
    String filename = "mail.txt";
    public void properties(){
        Path path = Paths.get(filename);
        try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
            Properties properties = new Properties();
            properties.load(reader);
            String address = properties.getProperty("system.mail.address");
            System.out.println(address);
        }catch(IOException ex){}
    }
    
    public void global(){
        //よくできません
        this.filename = "mail";
        ResourceBundle bundle = ResourceBundle.getBundle(filename);
        String message = bundle.getString("system.mail.errormessage");
        System.out.println(message);
    }

    public void csv(){
        
    }

    public void xml(){}

    public void dom(){}

    public void sax(){}

    public void xpath(){}

    public void jaxb(){}

    public void json(){}
}