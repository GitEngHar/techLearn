package composite;

public class File implements Entry {
    private String name;

    public File(String name){
        this.name = name;
    }

    @Override
    public void add(Entry entry){
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(){
        System.out.printf("%sを削除しました%n",name);
    }

    @Override
    public void rename(String name){
        this.name = name;
    }
}
