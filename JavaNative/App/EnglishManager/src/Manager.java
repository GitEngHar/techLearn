import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Manager implements ManagerInterface{
    private String userInfoFilePath = "./userinfo.txt";
    private String dataSetFilePath = "./dataset/";
    public String userName;
    public int numberOfQuestion = 0;
    private String questionDatas;
    public Manager(){
    }
    public String checkUserInfo(){
        Path path = Paths.get(userInfoFilePath);
        try{
            String content = Files.readString(path);
            return content;
        }catch(IOException e){
            return "NotFound";
        }
    }
    public void askForUserName(Scanner sc){
        System.out.println("あなたの名前を教えてください");
        System.out.print("名前 > ");
        if(sc.hasNext()){
            String userName = sc.next();
            registUserInfo(userName);
            System.out.println(userName + "さん これからよろしくお願いします。");
            this.userName = userName;
        } 
    }
    public void registUserInfo(String name){
        try{
            File f = new File(this.userInfoFilePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("name:" + name);
            bw.close();
        }catch(IOException e){
            System.out.println("RegistUserInfoError\n" + e.getMessage());
        }
    }
    public void setUserName(String content){
        Pattern p = Pattern.compile("name:(.*)");
        Matcher match = p.matcher(content);
        if(match.matches()){
            this.userName = match.group(1);
        }
    }
    public void helloUser(){
        System.out.println(this.userName + "さん よろしくお願いします。");
    } 
    public String checkDataSetDir(){
        Path path = Paths.get(dataSetFilePath);
        if(Files.exists(path)){
            return "OK";
        }else{
            try{
                Files.createDirectory(path);
            }catch(IOException e){
                System.out.println("DataSetCreateError: " + e.getMessage());
            }
            return "NotFound";
        }
    }   
    public File[] getDataSetFiles(){
        File dir = new File(dataSetFilePath);
        File[] files = dir.listFiles();
        return files;
    }
    public void presentsQuetionsFile(File[] files){
        System.out.println("出題してほしいファイル番号を選んでください");
        for(int i=0; i<files.length;i++){
            if(i%2==0){
                System.out.print(i+1 + " : " + files[i] + "  ");
            }else{
                System.out.println(i+1 + " : " + files[i] + "  ");
            }
        }
    }
    public String questionReady(int questionNumber,File[] files){
        String filePath = files[questionNumber-1].toString();
        Path path = Paths.get(filePath);
        try{
            String questionData = Files.readString(path);
            questionData = ManagerLogic.deleteEmptyLine(questionData);
            this.questionDatas = questionData; 
            this.numberOfQuestion = ManagerLogic.countLines(questionData)/2;
            return "OK";
        }catch(IOException e){
            return "NotFound";
        }catch(Exception e){
            return "NotFound";
        }
    }
    public ManagerLogic useManagerLogic(){
        ManagerLogic lg = new ManagerLogic(this.questionDatas);
        return lg;
    }
    public List<String> createQuestion(ManagerLogic lg){
        System.out.println("\n\n\n試験開始 ("+"問題数: " + this.numberOfQuestion+")"+"\n---------");
        System.out.println("");
        List<String> Questions =  lg.questionFormat();//問題の作成
        return Questions;
    }
    public List<String> getAnswer(ManagerLogic lg){
        return lg.getAnswer();
    }
    public void quizExits(List<String> questions,List<String> answers,User us,Scanner sc){
        for(int i=0; i<questions.size();i++){
            System.out.println(questions.get(i));
            System.out.println(us.answerQuiz(sc));
            System.out.println(answers.get(i));
        }
    }
}
