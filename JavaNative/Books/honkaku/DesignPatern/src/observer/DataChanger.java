package observer;

public class DataChanger extends Subject {
    private int status;
    public void execute(){
        status++;
        System.out.printf("ステータスが%dに変わりました%n",status);
        notifyObservers();
    }
}
