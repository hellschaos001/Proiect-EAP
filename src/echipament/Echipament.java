package echipament;

public class Echipament{
    public Producator getProducator() {
        return producator;
    }

    public void setProducator(Producator producator) {
        this.producator = producator;
    }

    private Producator producator;
    private String numeEchipament;
    private int anProductie;
    private float pret;

    public Echipament() {
    }

    public Echipament(String numeProducator, String telefon, String numeEchipament, int anProductie, float pret) {
        Producator prod = new Producator();
        this.producator=prod;
        this.producator.setNumeProducator(numeProducator);
        this.producator.setTelefon(telefon);
        this.numeEchipament = numeEchipament;
        this.anProductie = anProductie;
        this.pret = pret;
    }

    public String getNumeEchipament() {
        return numeEchipament;
    }

    public void setNumeEchipament(String numeEchipament) {
        this.numeEchipament = numeEchipament;
    }

    public int getAnProductie() {
        return anProductie;
    }

    public void setAnProductie(int anProductie) {
        this.anProductie = anProductie;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString(){
        return super.toString() + " " + numeEchipament + " " + anProductie + " " + pret;
    }
}