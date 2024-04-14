import java.util.Scanner;
public class User{
    public int choseNumberForQuestion(Scanner sc){
        System.out.print("番号 > ");
        if(sc.hasNextInt()){
            int QuestionNumber = sc.nextInt();sc.nextLine();
            return QuestionNumber;
        }else{
            return 0;
        }   
    }
    public String answerQuiz(Scanner sc){
        System.out.print("回答 > ");
        try{
            if(sc.hasNextLine()){
                String questionAnswer = sc.nextLine();
                return questionAnswer;
            }else{
                System.out.println("NODATA");
                return "NotData";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }
}
