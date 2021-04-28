package echipament;

public class Echipament extends Producator {
    private String numeEchipament;
    private int anProductie;
    private float pret;

    public Echipament() {
    }

    public Echipament(String nume_Producator, String telefon, String numeEchipament, int anProductie, float pret) {
        super(nume_Producator, telefon);
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