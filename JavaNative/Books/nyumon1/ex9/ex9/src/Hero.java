public class Hero {
    int hp;
    String name;
    static int money;
    Hero(String name){
        this.hp = 100;
        this.name = name;
    }
    void produce(){
        System.out.println("name:" + this.name + "\n" + "hp:" + this.hp);
        System.out.println("money:" + this.money);
    }
    Hero(){
        this("dummy");
    }
}
