package PackageProducator;

public class Producator {
    String Nume_Producator;
    String Telefon;

    public Producator() {
    }

    public Producator(String nume_Producator, String telefon) {
        Nume_Producator = nume_Producator;
        Telefon = telefon;
    }

    public String getNume_Producator() {
        return Nume_Producator;
    }

    public void setNume_Producator(String nume_Producator) {
        Nume_Producator = nume_Producator;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    @Override
    public String toString() {
        return Nume_Producator + " " + Telefon;
    }
}