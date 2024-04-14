import java.io.File;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Manager mn = new Manager();
        User us = new User();
        String checkedUserInfoAnswer = mn.checkUserInfo();
        Scanner sc = new Scanner(System.in, "Shift-JIS");
        if(checkedUserInfoAnswer.equals("NotFound")){//User未登録
            mn.askForUserName(sc);
        }else{
            mn.setUserName(checkedUserInfoAnswer);
            mn.helloUser();
        }
        mn.checkDataSetDir();
        
        File[] files = mn.getDataSetFiles();
        if(files.length > 0){
            mn.presentsQuetionsFile(files); // Manager : 問題のデータセットを提示する
            int questionNumber = us.choseNumberForQuestion(sc); // User : 問題のデータセットより対象を選ぶ
            String questionReady = mn.questionReady(questionNumber,files);
            if(questionReady.equals("OK")){
                ManagerLogic lg = mn.useManagerLogic();
                List<String> questions = mn.createQuestion(lg);
                List<String> answers = mn.getAnswer(lg);
                mn.quizExits(questions,answers,us,sc);// Manager : 問題を出題する User : 一問一答で回答する。
                
                //mn.setLog();// 回答ログを記録する
            }
            
        }else{
            System.out.println("datasetフォルダに問題ファイルを1つ以上格納してください");
        }
        sc.close();
    }
}
