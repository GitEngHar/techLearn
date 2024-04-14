public class App {
    public static void main(String[] args) throws Exception {
        Hero h1 = new Hero("haruki");
        Hero h2 = new Hero("erina");
        h1.money = 100;
        h2.money += 300;
        h2.hp += 100;
        h1.produce();
        h2.produce();
        
    }
}