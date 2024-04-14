import java.io.File;
import java.util.List;
import java.util.Scanner;

public interface ManagerInterface {
    void askForUserName(Scanner sc);//ユーザーに名前を尋ねる    
    void registUserInfo(String name);//ユーザー情報を登録
    void setUserName(String content);//ユーザー名をフィールドにセットする
    void helloUser();//ユーザーに挨拶
    String checkDataSetDir();//問題データが存在することを確認
    File[] getDataSetFiles();//問題データセット群を取得する
    void presentsQuetionsFile(File[] files);//問題データセット群を表示する
    String questionReady(int questionNumber,File[] files);//問題(試験)の準備をする
    ManagerLogic useManagerLogic();//Logicを利用する
    List<String> createQuestion(ManagerLogic lg);//問題(試験)を作成する
    List<String> getAnswer(ManagerLogic lg);//問題(試験)の答えを取得する
    void quizExits(List<String> questions,List<String> answers,User us,Scanner sc);//問題(試験)を実施する
}
