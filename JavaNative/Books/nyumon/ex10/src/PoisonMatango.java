public class PoisonMatango extends Matango {
    int attackNumber = 5;
    PoisonMatango(char suffix){
        super(suffix);
    }
    public void attack(Hero h){
        super.attack(h);
        int damage;
        if(this.attackNumber >= 0){
            System.out.println("さらに毒の胞子をばらまいた！");
            damage = h.getHp()/5;
            h.setHp(h.getHp()-damage);
            System.out.println(damage + "ポイントのダメージ");
            this.attackNumber -=1;
            System.out.println("残り" + this.attackNumber + "回の攻撃をしてくるぞ");
        }
    }
}
