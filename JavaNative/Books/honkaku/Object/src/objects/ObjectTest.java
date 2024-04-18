package objects;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import apps.DefaultFunction;
import apps.Function;
public class ObjectTest {
    public void ex1(){
        int value = 2;
        calcEx1(value);
        System.out.println("value1 : " + value);
    }

    public void calcEx1(int value){
        value ++;
        System.out.println("value2 : " + value);
    }

    public void ex2(){
        Entity et = new Entity();
        et.value = 1;
        calcEx2(et);
        System.out.println("value ex2-1:" + et.value);
    }

    public void calcEx2(Entity et){
        et.value ++;
        System.out.println("value ex2-2:" + et.value);
    }

    public void ex3(){
        String st = "This is a pen";
        String st2 = st.replace("pen","ball");
        System.out.println("string1: " + st);
        System.out.println("string2: " + st2);
    }

    public void ex4(){
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("実行前 : " + sb);
        sb.append(" World");
        System.out.println("実行後 : " + sb);
        AtomicInteger ati = new AtomicInteger(1);
        System.out.println("実行前 : " + ati );
        ati.incrementAndGet();
        System.out.println("実行後 : " + ati);
    }
    protected void ex5(int a){
        a += 1;
        System.out.println(a);
    }
    void ex6(int a){
        a += 1;
        System.out.println(a);
    }
    private void ex7(int a){
        a += 1;
        System.out.println(a);
    }
    protected void ex8(){
        List<Integer> list = new ArrayList(); 
        List<Integer> linkedList = new LinkedList();
        list.add(1);
        list.add(2);
        linkedList.add(2);
        linkedList.add(3);
    }
    protected void ex9(){
        DefaultFunction fu = new Function();
        //DefaultFunction fu = DefaultFunction.newinstance();
        System.out.println(fu.hello());
    }
}

class Entity{
    int value;
}