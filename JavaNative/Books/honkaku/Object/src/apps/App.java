package apps;

public class App{
    public static void main(String[] args) throws Exception {
        ObjectExec obe = new ObjectExec("hello"); 
        /*   
        testInterface obe2 = obe.reset("hello2");
        System.out.println(obe.hello());
        System.out.println(obe2.hello());*/
        obe.exec();
        
    }
}
