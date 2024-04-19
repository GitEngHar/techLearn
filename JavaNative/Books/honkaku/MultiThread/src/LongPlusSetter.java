public class LongPlusSetter implements Runnable {
    private String name;
    private LongHolder holder;

    public LongPlusSetter(String argName,LongHolder argHolder){
        name = argName;
        holder = argHolder;
    }

    public void run(){
        System.out.printf("[%s] started..",name);
        for(int counter = 0; counter < 1000000000; counter++){
            holder.serPlus();
        }
    }

}
