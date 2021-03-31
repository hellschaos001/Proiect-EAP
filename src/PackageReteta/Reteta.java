package PackageReteta;
import PackageMedicament.Medicament;

import java.util.HashMap;
public class Reteta {
    String Durata;
    HashMap<String,Medicament> lista_medicamente;

    public Reteta() {
    }

    public Reteta(String durata, HashMap<String, Medicament> lista_medicamente) {
        Durata = durata;
        this.lista_medicamente = lista_medicamente;
    }

    public String getDurata() {
        return Durata;
    }

    public void setDurata(String durata) {
        Durata = durata;
    }

    public HashMap<String, Medicament> getLista_medicamente() {
        return lista_medicamente;
    }

    public void setLista_medicamente(HashMap<String, Medicament> lista_medicamente) {
        this.lista_medicamente = lista_medicamente;
    }
    @Override
    public String toString (){
        return Durata + " " + lista_medicamente;
    }
}
