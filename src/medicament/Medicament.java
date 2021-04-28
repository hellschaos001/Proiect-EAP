package medicament;

public class Medicament {
    private String denumire;
    private String modAdministrare;
    private String prospect;

    public Medicament() {
    }

    public Medicament(String denumire, String mod_Administrare, String prostect) {
        this.denumire = denumire;
        modAdministrare = mod_Administrare;
        prospect = prostect;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getModAdministrare() {
        return modAdministrare;
    }

    public void setModAdministrare(String modAdministrare) {
        this.modAdministrare = modAdministrare;
    }

    public String getProspect() {
        return prospect;
    }

    public void setProspect(String prospect) {
        this.prospect = prospect;
    }
    @Override
    public String toString(){
        return denumire + " " + modAdministrare + " " + prospect;
    }
}
