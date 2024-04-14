import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            // String s = null;
            // System.out.println(s.length());
            throw new IOException();
            // int i = 0;
            // String i_str = "三";
            // i = Integer.parseInt(i_str);

        }catch(NullPointerException e){
            System.out.println("NullPointerException例外をキャッチしました");
            System.out.println("--スタックトレース(ここから)--");
            e.getStackTrace();
            e.printStackTrace();
            System.out.println("--スタックトレース(ここまで)--");
        }catch(NumberFormatException e){
            System.out.println("NumberFormatException例外をキャッチしました");
            System.out.println("--スタックトレース(ここから)--");
            e.getStackTrace();
            e.printStackTrace();
            System.out.println("--スタックトレース(ここまで)--");
        }catch(IOException e){
            System.out.println("IOException例外をキャッチしました");
            System.out.println("--スタックトレース(ここから)--");
            e.getStackTrace();
            e.printStackTrace();
            System.out.println("--スタックトレース(ここまで)--");            
        }

        

    }
}
