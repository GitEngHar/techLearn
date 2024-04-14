public class App {
    public static void main(String[] args) throws Exception {
        Account a = new Account("4649",1592);
        System.out.println("￥"+a.balance+"(口座番号="+a.accountNumber+")");
        System.out.println(a.judgeNumber(" 4649"));
    }
}
 