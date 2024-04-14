public class App {
    public static void main(String[] args) throws Exception {
        Hero h = new Hero();
        // King k = new King();
        // k.talk(h);        
        // Wizard w = new Wizard();
        // Wand wa = new Wand();
        // wa.setName("tk");
        // System.out.println(wa.getName());
        PoisonMatango mg = new PoisonMatango('A');
        mg.attack(h);
    }
}
