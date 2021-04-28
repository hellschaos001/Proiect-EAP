package cabinet;
import java.util.Date;

public class Cabinet {
    private String nume;
    private String adresa;
    private String site;
    private String email;
    private String telefon;
    private Date dataInfiintarii;

    public Cabinet() {
    }

    public Cabinet(String nume, String adresa, String site, String email, String telefon, Date dataInfiintarii) {
        this.nume = nume;
        this.adresa = adresa;
        this.site = site;
        this.email = email;
        this.telefon = telefon;
        this.dataInfiintarii = dataInfiintarii;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getDataInfiintarii() {
        return dataInfiintarii;
    }

    public void setDataInfiintarii(Date dataInfiintarii) {
        this.dataInfiintarii = dataInfiintarii;
    }

    @Override
    public String toString(){
        return nume + " " + adresa + " " + telefon;

    }
}