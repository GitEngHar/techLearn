import create.Builder;
import create.Director;
import create.Page;
import create.TopPageBuilder;
import structure.*;
import abstractstructure.*;
import composite.*;
import command.*;
import strategy.*;

public class App {
    public static void main(String[] args) throws Exception {
        commandBooks();
    }

    public static void strategyBooks(){
        strategy.Book comic = new strategy.Book(600);
        strategy.Book technicalBook = new strategy.Book(2000);

        strategy.Strategy discount = new DiscountStrategy();
        strategy.Strategy specialDiscount = new specialDiscount();
        
        strategy.Shop discountShop = new Shop(discount);
        strategy.Shop specialShop = new Shop(specialDiscount);
        
        discountShop.sell(comic);
        specialShop.sell(technicalBook);

        System.out.printf("漫画の値段 : %f",comic.getAmount());
        System.out.printf("漫画の値段 : %f",technicalBook.getAmount());
        
    }
    public static void commandBooks(){
        command.Book comic = new command.Book(600);
        command.Book technicalBook = new command.Book(1700);
        
        Command discountCommand = new Discount();

        Command specialdiscoutCommand = new SpecialDiscount();

        discountCommand.setBook(comic);
        discountCommand.execute();
        System.out.printf("割引した漫画の値段は %f 円です%n",comic.getAmount());

        specialdiscoutCommand.setBook(technicalBook);
        specialdiscoutCommand.execute();
        System.out.printf("割引した技術書の値段は %f 円です",technicalBook.getAmount());
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
