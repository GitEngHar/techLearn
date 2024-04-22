package strategy;

public class specialDiscount implements Strategy{
    public void discount(Book book){
        double amount = book.getAmount();
        book.setAmount(amount*0.7);
    }
}
