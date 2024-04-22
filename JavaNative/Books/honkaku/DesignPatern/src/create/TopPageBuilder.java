package create;

public class TopPageBuilder implements Builder {
    private TopPage page;
    public TopPageBuilder(){
        this.page = new TopPage();
    }
    public void createHeader(){
        this.page.setHeader("Header");
    };
    public void createContents(){
        this.page.setCotents("contents");
    };
    public void createFooter(){
        this.page.setFooter("footer");
    };
    public Page getResult(){
        return this.page;
    };
}
