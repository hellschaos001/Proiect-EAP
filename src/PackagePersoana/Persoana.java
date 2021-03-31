package PackagePersoana;

public class Persoana {
    String CNP;
    String Nume;
    String Prenume;
    String Adresa;
    String Telefon;

    public Persoana() {
    }

    public Persoana(String CNP, String nume, String prenume, String adresa, String telefon) {
        this.CNP = CNP;
        Nume = nume;
        Prenume = prenume;
        Adresa = adresa;
        Telefon = telefon;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    @Override
    public String toString() {
        return CNP + " " + Nume + " " + Prenume + " " + Telefon + " " + Adresa;
    }
}
