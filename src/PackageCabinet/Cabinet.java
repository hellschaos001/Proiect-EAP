package PackageCabinet;
import java.util.Date;

public class Cabinet {
    String Nume;
    String Adresa;
    String Site;
    String Email;
    String Telefon;
    Date Data_Infiintarii;

    public Cabinet() {
    }

    public Cabinet(String nume, String adresa, String site, String email, String telefon, Date data_Infiintarii) {
        Nume = nume;
        Adresa = adresa;
        Site = site;
        Email = email;
        Telefon = telefon;
        Data_Infiintarii = data_Infiintarii;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public Date getData_Infiintarii() {
        return Data_Infiintarii;
    }

    public void setData_Infiintarii(Date data_Infiintarii) {
        Data_Infiintarii = data_Infiintarii;
    }

    @Override
    public String toString(){
        return Nume + " " + Adresa + " " + Telefon;

    }
}