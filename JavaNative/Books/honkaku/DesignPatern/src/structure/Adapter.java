package structure;

public class Adapter extends OldSystem implements newSystemInterface {
    @Override
    public void process(){
        oldProcess();
    }
}
