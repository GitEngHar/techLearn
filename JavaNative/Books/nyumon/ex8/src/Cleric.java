import java.util.Random;
import java.lang.Thread;
public class Cleric {
    String name;
    int hp = 50;
    static final int max_hp = 50;
    int mp = 10;
    static final int max_mp = 10;
    Cleric(String name , int hp , int mp){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }
    Cleric(String name , int hp){
        this(name,hp,Cleric.max_mp);
    }
    Cleric(String name){
        this(name,Cleric.max_hp,Cleric.max_mp);
    }
    void produce(){
        System.out.println("name:" + this.name + "\n" + "hp:" + this.hp+ "\n" + "mp:" + this.mp + "\n" +"---------" + "\n");
    }
    void selfAid(){
        this.mp -= 5;
        this.hp -= 5;
        System.out.println("セルフエイドを唱えた!MPが" + this.mp + "になった");
        this.hp = this.max_hp;
        System.out.println("HPが全回復した。" + this.hp + "になった");

    }

    public int pray(int sec){
        Random r = new Random();
        Thread t = new Thread();
        int plus_mp = sec + r.nextInt(3);
        int heal_mp = Math.min(this.max_mp-this.mp,plus_mp);
        try {
            System.out.println(this.mp + "だ! 祈る..");
            t.sleep(sec*1000);
            this.mp += heal_mp;
            System.out.println("祈った。MPが" + this.mp + "になった");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return heal_mp; 
    }

    
}
