package apps;

public interface testInterface {
    String hello();
    static testInterface interfaces(String message){
        return new ObjectExec(message);//ファクトリメソッド
    }
}
