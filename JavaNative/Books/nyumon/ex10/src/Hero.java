public class Hero {
    private int hp;
    private String name;
    Hero(){
        this.name = "Haruki";
        this.hp = 50;
    }
    private void die(){
        System.out.println("Hero die...");
    }
    public String getName(){
        return name;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }
}
