public class Account {
    String accountNumber;
    int balance;    
    public Account(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public boolean judgeNumber(String accountNumber){
        if(this.accountNumber.equals(accountNumber.trim())){
            return true;
        }else{
            return false;
        }
    }
}
