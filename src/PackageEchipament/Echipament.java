package PackageEchipament;

import PackageProducator.Producator;

public class Echipament extends Producator {
    String Nume_Echipament;
    int An_Productie;
    float Pret;

    public Echipament() {
    }

    public Echipament(String nume_Producator, String telefon, String nume_Echipament, int an_Productie, float pret) {
        super(nume_Producator, telefon);
        Nume_Echipament = nume_Echipament;
        An_Productie = an_Productie;
        Pret = pret;
    }

    public String getNume_Echipament() {
        return Nume_Echipament;
    }

    public void setNume_Echipament(String nume_Echipament) {
        Nume_Echipament = nume_Echipament;
    }

    public int getAn_Productie() {
        return An_Productie;
    }

    public void setAn_Productie(int an_Productie) {
        An_Productie = an_Productie;
    }

    public float getPret() {
        return Pret;
    }

    public void setPret(float pret) {
        Pret = pret;
    }

    @Override
    public String toString(){
        return super.toString() + " " + Nume_Echipament + " " + An_Productie + " " + Pret;
    }
}