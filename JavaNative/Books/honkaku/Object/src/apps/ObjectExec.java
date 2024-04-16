package apps;
import objects.ObjectTest;

public class ObjectExec extends ObjectTest{
    public void exec(){
        super.ex5(1); // 継承しているためコンパイルが通る
        super.ex6(); // 同一パッケージではないことによるエラー
        super.ex7(); // 同一クラスではないことによるエラー
    }
}
