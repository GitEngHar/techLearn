package apps;
import objects.ObjectTest;
import static apps.UserInfo.*;
public class ObjectExec extends ObjectTest implements testInterface {
    String message;
    ObjectExec(String message){
        this.message = message;
    }
    public testInterface reset(String message){
        return  testInterface.interfaces(message);
    }
    public void exec(){
        //super.ex5(1); // 継承しているためコンパイルが通る
        //super.ex6(); // 同一パッケージではないことによるエラー
        //super.ex7(); // 同一クラスではないことによるエラー
        /*System.out.println(username);
        System.out.println(old);
        System.out.println(number);*/
        super.ex9();
    }
    public String hello(){
        return this.message;
    }

}
