package create;


public interface Builder {
    void createHeader();
    void createContents();
    void createFooter();
    Page getResult();
}
