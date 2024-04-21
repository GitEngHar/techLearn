public class App {
    public static void main(String[] args) throws Exception {
        Builder builder = new TopPageBuilder();
        Director director = new Director(builder);

        Page page = director.construct();
    }
}
