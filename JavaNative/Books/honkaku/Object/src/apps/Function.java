package apps;

public class Function implements DefaultFunction {
    String sayWord = "hello";
    
    public String hello(){
        return this.sayWord;
    }

    public void setWord(String word){
        this.sayWord = word;
    }
}
