import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> students = new ArrayList<Student>();// private student 配列宣言
    
    public void add(Student student){
        students.add(student);
    }// student 追加 メソッド

    public List<Student> getStudent(){
        return students;
    }
    // student 取得 メソッド
}
