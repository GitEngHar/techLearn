package apps;

public interface DefaultFunction {
    String hello();
    public static DefaultFunction newinstance(){
        return new Function(); //ファクトリークラス
    } 
}
