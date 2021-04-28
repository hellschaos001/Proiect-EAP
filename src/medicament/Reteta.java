package medicament;

import java.util.HashMap;
public class Reteta {
    private String durata;
    HashMap<String,Medicament> listaMedicamente;

    public Reteta() {
    }

    public Reteta(String durata, HashMap<String, Medicament> listaMedicamente) {
        this.durata = durata;
        this.listaMedicamente = listaMedicamente;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public HashMap<String, Medicament> getListaMedicamente() {
        return listaMedicamente;
    }

    public void setListaMedicamente(HashMap<String, Medicament> listaMedicamente) {
        this.listaMedicamente = listaMedicamente;
    }
    @Override
    public String toString (){
        return durata + " " + listaMedicamente;
    }
}
