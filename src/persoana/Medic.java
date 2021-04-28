package persoana;
import java.util.Calendar;

public class Medic extends Persoana {
    private  String specializare;
    private int aniExperienta;
    private Calendar dataAngajarii;

    public Medic() {
    }

    public Medic(String cnp, String nume, String prenume, String adresa, String telefon, String specializare, int aniExperienta, Calendar dataAngajarii) {
        super(cnp, nume, prenume, adresa, telefon);
        this.specializare = specializare;
        this.aniExperienta = aniExperienta;
        this.dataAngajarii = dataAngajarii;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    public Calendar getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Calendar dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    @Override
    public String toString(){
        return super.toString() + " " + specializare;
    }
}
