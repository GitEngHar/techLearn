public class Student {
    int score = 0;
    String name = "";
    Student(int score, String name){
        this.score = score;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
}
