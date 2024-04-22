import create.Builder;
import create.Director;
import create.Page;
import create.TopPageBuilder;
import structure.*;
public class App {
    public static void main(String[] args) throws Exception {
        
    }
    public static void structureTest(){
        Target target = new Adapter();
        target.process();

    }
    public static void createTest(){
        Builder builder = new TopPageBuilder();
        Director director = new Director(builder);

        Page page = director.construct();
    }
}
