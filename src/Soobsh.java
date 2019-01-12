import java.util.Date;

public class Soobsh {
    Date data;
    String text;
    String author;


    public Soobsh() {
    }

    public Soobsh(Date data, String text, String author) {
        this.data = data;
        this.text = text;
        this.author = author;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}
