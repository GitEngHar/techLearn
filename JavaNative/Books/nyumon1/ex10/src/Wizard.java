public class Wizard {
    private int hp;
    private int mp;
    String name;
    Wand wand;
    Wizard(){
        this.name = "Erina";
        this.hp = 30;
        this.mp = 20;
    }
    void heal(Hero h){
        int basePoint = 10;
        int recovPoint = (int)(basePoint * this.wand.power);

        h.setHp(h.getHp() + recovPoint);
        System.out.println(h.getName() + "のHPを" + recovPoint + "回復した!");
    }
    public void setHp(int hp){
        if(0 > hp){
            this.hp = 0;    
        }
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }
    public void setMp(int mp){
        if(0 > mp){
            this.mp = 0;    
        }
        this.mp = mp;
    }
    public int getMp(){
        return this.mp;
    }
}
