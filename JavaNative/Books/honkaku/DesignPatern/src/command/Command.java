package command;

public abstract class Command {
    protected Book book;

    public void setBook(Book book){
        this.book = book;
    }

    public abstract void execute();
}
