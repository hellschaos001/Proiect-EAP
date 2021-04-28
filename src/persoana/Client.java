package persoana;

public class Client extends Persoana {
    private boolean asigurat;
    private boolean rezultatTestCOVID;
    private boolean salariat;
    private String boli;
    private String alergeni;
    private String grupaSange;

    public Client() {
    }

    public Client(String cnp, String nume, String prenume, String adresa, String telefon, boolean asigurat, boolean rezultatTestCOVID, boolean salariat, String boli, String alergeni, String grupaSange) {
        super(cnp, nume, prenume, adresa, telefon);
        this.asigurat = asigurat;
        this.rezultatTestCOVID = rezultatTestCOVID;
        this.salariat = salariat;
        this.boli = boli;
        this.alergeni = alergeni;
        this.grupaSange = grupaSange;
    }

    public boolean isAsigurat() {
        return asigurat;
    }

    public void setAsigurat(boolean asigurat) {
        this.asigurat = asigurat;
    }

    public boolean isRezultatTestCOVID() {
        return rezultatTestCOVID;
    }

    public void setRezultatTestCOVID(boolean rezultatTestCOVID) {
        this.rezultatTestCOVID = rezultatTestCOVID;
    }

    public boolean isSalariat() {
        return salariat;
    }

    public void setSalariat(boolean salariat) {
        this.salariat = salariat;
    }

    public String getBoli() {
        return boli;
    }

    public void setBoli(String boli) {
        this.boli = boli;
    }

    public String getAlergeni() {
        return alergeni;
    }

    public void setAlergeni(String alergeni) {
        this.alergeni = alergeni;
    }

    public String getGrupaSange() {
        return grupaSange;
    }

    public void setGrupaSange(String grupaSange) {
        this.grupaSange = grupaSange;
    }

    public void adaugareClient()
    {

    }

    @Override
    public String toString(){
        return super.toString() + " " + boli + " " + alergeni + " " + grupaSange;
    }
}
