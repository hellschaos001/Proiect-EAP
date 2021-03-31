package PackageMedicament;

public class Medicament {
    String Denumire;
    String Mod_Administrare;
    String Prospect;

    public Medicament() {
    }

    public Medicament(String denumire, String mod_Administrare, String prostect) {
        Denumire = denumire;
        Mod_Administrare = mod_Administrare;
        Prospect = prostect;
    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public String getMod_Administrare() {
        return Mod_Administrare;
    }

    public void setMod_Administrare(String mod_Administrare) {
        Mod_Administrare = mod_Administrare;
    }

    public String getProspect() {
        return Prospect;
    }

    public void setProspect(String prospect) {
        Prospect = prospect;
    }
    @Override
    public String toString(){
        return Denumire + " " + Mod_Administrare + " " + Prospect;
    }
}
