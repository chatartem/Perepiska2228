import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Chat {
    String nazvanie;
    String author;
    Date dataSozdania;
    Date dataPoslObnovl;
    ArrayList<Soobsh> soosbchenia;

    public Chat() {
    }

    public Chat(String nazvanie, String author, Date dataSozdania) {
        this.nazvanie = nazvanie;
        this.author = author;
        this.dataSozdania = dataSozdania;
        soosbchenia = new ArrayList<Soobsh>();
    }


//getters and setters hahaha


    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDataSozdania() {
        return dataSozdania;
    }

    public void setDataSozdania(Date dataSozdania) {
        this.dataSozdania = dataSozdania;
    }

    public Date getDataPoslObnovl() {
        return dataPoslObnovl;
    }

    public void setDataPoslObnovl(Date dataPoslObnovl) {
        this.dataPoslObnovl = dataPoslObnovl;
    }

    public ArrayList<Soobsh> getSoosbchenia() {
        return soosbchenia;
    }

    public void setSoosbchenia(ArrayList<Soobsh> soosbchenia) {
        this.soosbchenia = soosbchenia;
    }




}
