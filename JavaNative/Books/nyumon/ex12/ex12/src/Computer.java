public class Computer extends TangibleAsset {
    private String name;
    private int price;
    private String color;
    private String makerName;
    public Computer(String name, int price, String color,String makerName){
        super(name,price,color);
        this.name = name;
        this.price = price;
        this.color = color;
        this.makerName = makerName;
    }
    public String getName(){
        return this.name;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public String getMakerName(){
        return this.makerName;
    }

}
