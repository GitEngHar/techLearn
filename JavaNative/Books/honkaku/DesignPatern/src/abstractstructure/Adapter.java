package abstractstructure;

public class Adapter extends newSystemAbstract{
    private OldSystem oldsystem;
    public Adapter(){
        this.oldsystem = new OldSystem();
    }
    @Override
    public void process(){
        this.oldsystem.oldProcess();
    }
}
