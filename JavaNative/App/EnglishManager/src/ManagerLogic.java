import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;

public class ManagerLogic {
    public List<String> japanese = new ArrayList<String>();
    public List<String> english = new ArrayList<String>();
    private List<String> answer = new ArrayList<String>();
    public ManagerLogic(String questions){
        String[] splitLineQuestion = questions.split("\n");
        for (int i=0;i<splitLineQuestion.length;i++){
            if(i%2 == 0){
                this.english.add(splitLineQuestion[i]);
            }else{
                this.japanese.add(splitLineQuestion[i]);
            }
        }
    }
    
    public static int countLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return  lines.length;
    }

    public static String deleteEmptyLine(String content){
        content = content.replaceAll("(\n|\r|\n\r|\r\n){2,}", "\n");
        content = content.replaceAll("[ \t\\x0B\f]+(\n|\r|\n\r|\r\n)", "");
        if(content.substring(content.length() - 1).equals("\n")){
            content=content.substring(0,content.length()-1);
        }
        return content;
    }

    public List<String> questionFormat(){
        List<String> wantToLogicBaseQuestions = new ArrayList<String> ();
        List<String> wantToLogicQuestions = new ArrayList<String> ();
        List<String> presenterQuestionsTranslation = new ArrayList<String> ();
        List<String> questionBaseLanguage = new ArrayList<String>();
        List<String> questionLanguage = new ArrayList<String>();
        int numberQuestionPattern = 2;
        int startQuestionAdd = 0;
        int endQuestionAdd = 0;
        int numberQuestionSection = this.japanese.size()/numberQuestionPattern;

        for(int j=0;j<numberQuestionPattern;j++){
            int numberFormat = j;
            wantToLogicBaseQuestions = new ArrayList<String> ();//値を初期化
            wantToLogicQuestions = new ArrayList<String> ();
            startQuestionAdd = (j) * numberQuestionSection;//0~3,3~6,6~9
            endQuestionAdd = numberQuestionSection * (j+1);
            questionBaseLanguage = judgeQuestionBaseLanguage(numberFormat);
            questionLanguage = judgeQuestionLanguage(numberFormat);
            for(int i=startQuestionAdd; i<endQuestionAdd;i++){
                wantToLogicBaseQuestions.add(questionBaseLanguage.get(i));
                wantToLogicQuestions.add(questionLanguage.get(i));
            }
            //ランダム問題に問題番号と問題を入力。問題セットを返してくる。
            presenterQuestionsTranslation.addAll(RandomQuestionLogic(numberFormat,wantToLogicBaseQuestions,wantToLogicQuestions));
        }
        if(this.japanese.size() % numberQuestionPattern != 0){
            int numberOfQuestion = numberQuestionSection*numberQuestionPattern;
            int numberFormat = 0;
            wantToLogicBaseQuestions = new ArrayList<String> ();//値を初期化
            wantToLogicQuestions = new ArrayList<String> ();
            questionBaseLanguage = judgeQuestionBaseLanguage(numberFormat);
            questionLanguage = judgeQuestionLanguage(numberFormat);
            for(int i=numberOfQuestion; i<this.japanese.size();i++){
                wantToLogicBaseQuestions.add(questionBaseLanguage.get(i));
                wantToLogicQuestions.add(questionLanguage.get(i));
                presenterQuestionsTranslation.addAll(RandomQuestionLogic(numberFormat,wantToLogicBaseQuestions,wantToLogicQuestions));
            }
        }

        return presenterQuestionsTranslation;
    }
    public List<String> judgeQuestionBaseLanguage(int numberFormat){
        List<String> questionBaseLanguage = new ArrayList<String>();
        switch(numberFormat){
            case 1:
                questionBaseLanguage = this.japanese;
                break;
            case 0:
                questionBaseLanguage = this.english;
                break;
            case 2:
                questionBaseLanguage = this.english;
                break;                
        }
        return questionBaseLanguage;
    }
    public List<String> judgeQuestionLanguage(int numberFormat){
        List<String> questionLanguage = new ArrayList<String>();
        switch(numberFormat){
            case 1:
                questionLanguage = this.english;
                break;
            case 0:
                questionLanguage = this.japanese;
                break;
            case 2:
                questionLanguage = this.japanese;
                break;                
        }
        return questionLanguage;
    }    
    public List<String> RandomQuestionLogic(int numberFormat,
        List<String> wantToLogicBaseQuestions,
        List<String> wantToLogicQuestions
    ){
        List<String> questionDatas = new ArrayList<String>();
        switch(numberFormat){
            case 1:
                questionDatas.addAll(Translation(wantToLogicBaseQuestions,wantToLogicQuestions));
                break;
            case 0:
                questionDatas.addAll(Leafwarbler(wantToLogicBaseQuestions,wantToLogicQuestions));
                break;
            case 2:
                questionDatas.addAll(Translation(wantToLogicBaseQuestions,wantToLogicQuestions));
                break;
                //Leafwarbler(wantToLogicBaseQuestions);
        }
        return questionDatas;
    }
    public List<String> Disarrange(List<String> questions){
        return questions;
    }
    public List<String> Translation(
        List<String> wantToLogicBaseQuestions
        ,List<String> wantToLogicQuestions
    ){
        String explanation = "Q. 次の文を翻訳してください\n";
        String answerExplanation = "A.";
        List<String> translationQuestion = new ArrayList<String>(); 
        for (int i=0;i<wantToLogicBaseQuestions.size();i++){
            translationQuestion.add(explanation + wantToLogicBaseQuestions.get(i));
            this.answer.add(answerExplanation + wantToLogicQuestions.get(i) + "\n");
        }
        return translationQuestion;
    }
    public List<String> Leafwarbler(
        List<String> wantToLogicBaseQuestions
        ,List<String> wantToLogicQuestions
    ){
        List<String> LeafwarblerQuestion = new ArrayList<String>();
        String[] splitBaseQuestion ;
        String leafWarblerStr;//置換対象文字列
        String leafWarbler = "□";//虫食い文字列
        String explanation = "Q. 次の□を埋めてください\n";
        String leafWarbledStr = "";
        String answerExplanation = "A. ";
        String answerChars = "";
        String answerWard = "";
        String answerChar = "";
        StringBuilder replacLeafWarblerWord ;
        StringBuilder replaceAnswer ;
        int leafWarblerCharPosition;
        int numberLeafWarblerWord;//this is a pen [t,2][i,3]
        int numberLeafWarblerWordChar;
        int numberReplaceChar;
        for (int i=0;i<wantToLogicBaseQuestions.size();i++){
            answerChars = "";
            leafWarbledStr = "";
            leafWarblerStr = wantToLogicBaseQuestions.get(i);
            splitBaseQuestion = leafWarblerStr.split(" ");
            numberLeafWarblerWord = splitBaseQuestion.length;
            Random ra = new Random();
            //答えの文字列を作成する
            for(int j=0; j<numberLeafWarblerWord;j++){
                numberLeafWarblerWordChar = splitBaseQuestion[j].length();
                numberReplaceChar = numberLeafWarblerWordChar/2;
                answerWard = "";
                for(int l=0;l<numberLeafWarblerWordChar;l++){
                    //answerChars += "-";
                    answerWard += "-";
                }
                if(numberLeafWarblerWordChar>1){ //単語の文字数が1の時は置き換えない
                    for(int k=0;k<numberReplaceChar;k++){
                        replacLeafWarblerWord = new StringBuilder();
                        replaceAnswer = new StringBuilder();
                        leafWarblerCharPosition = ra.nextInt(numberLeafWarblerWordChar);
                        answerChar = String.valueOf(splitBaseQuestion[j].charAt(leafWarblerCharPosition));
                        if(!answerChar.equals(leafWarbler)){
                            replaceAnswer.append(answerWard);
                            replaceAnswer.replace(leafWarblerCharPosition,leafWarblerCharPosition+1,answerChar);   
                            answerWard = replaceAnswer.toString();
                        }
                        replacLeafWarblerWord.append(splitBaseQuestion[j]);
                        replacLeafWarblerWord.replace(leafWarblerCharPosition,leafWarblerCharPosition+1,leafWarbler);
                        splitBaseQuestion[j] = replacLeafWarblerWord.toString();
                    }
                    answerChars +=  answerWard + " ";
                }
                leafWarbledStr += splitBaseQuestion[j] + " ";
            }
            answerChars = answerChars.replace("-", "");
            LeafwarblerQuestion.add(explanation + wantToLogicQuestions.get(i) + "\n" + leafWarbledStr);
            this.answer.add(answerExplanation + answerChars + "\n");
        }
        return LeafwarblerQuestion;
    }
    public List<String> getAnswer(){
        return this.answer;
    }    
}



