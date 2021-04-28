package persoana;

public class Persoana {
    protected String cnp;
    protected String nume;
    protected String prenume;
    protected String adresa;
    protected String telefon;

    public Persoana() {
    }

    public Persoana(String cnp, String nume, String prenume, String adresa, String telefon) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return cnp + " " + nume + " " + prenume + " " + telefon + " " + adresa;
    }
}
