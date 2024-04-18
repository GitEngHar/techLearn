public class Incrementer implements Runnable{
    private String name;
    private HolderInt holders;

    public Incrementer(String name,HolderInt holder){
        this.name = name;
        this.holders = holder;
    }
    public void run(){
        System.out.printf("[%s] started %n",name);
        for(int i=0;i<1000000;i++){
            holders.increment();
        }
        System.out.printf("[%s] started %n",name);
    }
}
