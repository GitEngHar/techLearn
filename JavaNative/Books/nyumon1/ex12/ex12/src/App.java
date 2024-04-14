public class App {
    public static void main(String[] args) throws Exception {
        Computer c = new Computer("mypc",1000000,"red","apple") ;
        String pcname = c.getName();
        System.out.println(pcname);
    }
}
