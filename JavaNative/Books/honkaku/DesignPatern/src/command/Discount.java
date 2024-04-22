package command;

public class Discount extends Command{
    @Override
    public void execute(){
        double amount = book.getAmount();
        book.setAmount(amount*0.9);
    }
}
