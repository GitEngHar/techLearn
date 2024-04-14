public class Wand {
    String name;
    double power;
    public void setName(String name) throws IllegalAccessException{
        if (name == null){
            throw new IllegalAccessException("Nullを入力しないでください");
        }else if (3 > name.length()){
            throw new IllegalAccessException("3文字以上の入力をしてください");
        } 
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPower(double power) throws IllegalAccessException{
        if (power >= 100){
            throw new IllegalAccessException("魔力強化が強すぎます");
        }else if (0.5>=power){
            throw new IllegalAccessException("魔力強化が弱すぎます");
        }
    }
    public double getPower(){
        return this.power;
    }
}
