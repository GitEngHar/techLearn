public class Matango {
    private int hp = 50;
    private char suffix;
    public Matango(char suffix){
        this.suffix = suffix;
    }
    public void attack(Hero h){
        System.out.println("キノコ"+suffix+"の攻撃");
        System.out.println("10のダメージ");
        h.setHp(h.getHp() - 10);
    }
}
