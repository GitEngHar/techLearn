package create;

public class Page {
    private String header;
    private String contents;
    private String footer;

    public String getHeader(){
        return this.header;
    }
    public String getCotents(){
        return this.contents;
    }
    public String getFooter(){
        return this.footer;
    }

    public void setHeader(String header){
        this.header = header;
    }
    public void setCotents(String contents){
        this.contents = contents;
    }
    public void setFooter(String footer){
        this.footer = footer;
    }
}
