import create.Builder;
import create.Director;
import create.Page;
import create.TopPageBuilder;
import structure.*;
import abstractstructure.*;
import composite.*;

public class App {
    public static void main(String[] args) throws Exception {
        compositeTest();
    }
    public static void compositeTest(){
        composite.File file1 = new composite.File("file1");
        composite.File file2 = new composite.File("file2");
        composite.File file3 = new composite.File("file3");

        composite.Directory dir1 = new composite.Directory("dir1");
        dir1.add(file1);

        composite.Directory dir2 = new composite.Directory("dir2");
        dir2.add(file2);
        dir2.add(file3);

        dir1.add(dir2);

        dir1.remove();
    }
    public static void abstractStructureTest(){
        newSystemAbstract target = new abstractstructure.Adapter();
        target.process();
    }
    public static void structureTest(){
        newSystemInterface target = new structure.Adapter();
        target.process();

    }
    public static void createTest(){
        Builder builder = new TopPageBuilder();
        Director director = new Director(builder);

        Page page = director.construct();
    }
}
