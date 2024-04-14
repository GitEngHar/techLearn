import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class exTest3 {
    String wFileName = "a";
    exTest3(String wFileName){
        this.wFileName = wFileName;
    }
    public void exits(){
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.wFileName))){
            List<String> lines = new ArrayList<String>();
            lines.add("abc");
            lines.add("def");
            lines.forEach(s ->{
                try{
                    writer.write(s + "+plusExits\n");
                } catch(IOException ioex){

                }
            } );
        }catch(IOException ioex){
            ioex.printStackTrace(System.out);
        }
}
}
