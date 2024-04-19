public class LongHolder {
    private long longNum = 0;
    public long getResult(){
        return this.longNum;
    }

    public void serPlus(){
        this.longNum = 1;
        check(longNum);
    }

    public void serMinus(){
        this.longNum = -1;
        check(longNum);
    }

    public void check(long longNum){
        if(longNum != 1 && longNum != -1){
            throw new RuntimeException("longNum" + longNum);
        }
    }
}
