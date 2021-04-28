package echipament;

public class Producator {
    protected String numeProducator;
    protected String telefon;

    public Producator() {
    }

    public Producator(String numeProducator, String telefon) {
        this.numeProducator = numeProducator;
        this.telefon = telefon;
    }

    public String getNumeProducator() {
        return numeProducator;
    }

    public void setNumeProducator(String numeProducator) {
        this.numeProducator = numeProducator;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return numeProducator + " " + telefon;
    }
}