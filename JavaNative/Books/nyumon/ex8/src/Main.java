public class Main {
    public static void main(String[] args) throws Exception {
        Cleric c = new Cleric("Haruki");
        Cleric c2 = new Cleric("Erina",40);
        Cleric c3 = new Cleric("Makoto",30,6);
        
        c.produce();
        c2.produce();
        c3.produce();
        // Hero h = new Hero();
        // h.name = "ミナト";
        // h.hp = 100;
        // System.out.println("勇者" + h.name + "を生み出しました！");
        
        // Matango m1 = new Matango();
        // m1.hp = 50;
        // m1.suffix = 'A';

        // Matango m2 = new Matango();
        // m2.hp = 46;
        // m2.suffix = 'B';

        // h.slip();
        // m1.run();
        // m2.run();
        // h.run();
    }
}
