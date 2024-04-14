import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEx {
    public void exits(){
        ex4();
    }
    public void ex1(){
        File dir = new File("C:\\Users\\杉山聖哉\\Documents\\java\\Books\\files\\sample");
        for(String item : dir.list()){
            System.out.println(item);
        }
    }
    public void ex2(){
        Path path1 = Paths.get("C:\\Users\\杉山聖哉\\Documents\\java\\Books\\files\\sample\\file1.txt");
        System.out.println(path1);
        Path path2 = Paths.get("C:","Users","杉山聖哉","Documents","java","Books","files","sample","file2.txt");
        System.out.println(path2);
        URI uri = URI.create("file:///C:/Users/杉山聖哉/Documents/java/Books/files/sample/file3.txt");
        Path path3 = Paths.get(uri);
        System.out.println(path3);
        System.out.println(path1.getParent());
        System.out.println(path1.resolveSibling("file2.txt"));
        System.out.println(path1.resolveSibling("README.md").normalize());    
    }
    public void ex3(){
        //一度に多くの文字列を含んだ膨大なファイルを読み込むと、メモリの確保が大変。最悪エラーで停止する
        //before java6
        /*
         * Fileクラスを用いてファイルをインスタンス化
         * InputStreamクラスのFileInputStream(実装クラス?)にファイルを渡しストリームをインスタンス化
         * インスタンスのreadメソッドを内容を全て抽出しきるまで読み取る
         */
        File file = new File("C:\\Users\\杉山聖哉\\Documents\\java\\Books\\files\\README.md");
        InputStream is = null;
        try{
            is = new FileInputStream(file);
            for(int ch;(ch = is.read()) != -1;){
                System.out.print((char)ch);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }finally{
            if(is !=null){
                try{
                    is.close();
                }catch(IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }
    public void ex4(){
        Path path = Paths.get("C:\\Users\\杉山聖哉\\Documents\\java\\Books\\files\\README.md");
        try(InputStream is = Files.newInputStream(path)){
            for(int ch; (ch = is.read()) != -1;){
                System.out.print((char)ch);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
