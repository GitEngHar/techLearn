import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class exTest2 {
    String testStr = "asbd";
    exTest2(String testStr){
        this.testStr = testStr;
    }
    Integer intStr = 0;
    public void exits(){
        
        Logger log = System.getLogger("exTest2");
        try{
             intStr = Integer.parseInt(testStr);
             System.out.println(intStr);
        }catch(NumberFormatException e){
            log.log(Level.INFO, "class is :" + log.getName());
            log.log(Level.ERROR,"error , " + e);
            
        }
        

    }
}

