package PackageProgramare;
import java.util.Calendar;

public class Programare {
    Calendar Data;
    String Detalii_Programare;
    String Recomandari;
    String CNP_Client;
    String CNP_Medic;

    public Programare() {
    }

    public Programare(Calendar data, String detalii_Programare, String recomandari, String CNP_Client, String CNP_Medic) {
        Data = data;
        Detalii_Programare = detalii_Programare;
        Recomandari = recomandari;
        this.CNP_Client = CNP_Client;
        this.CNP_Medic = CNP_Medic;
    }

    public Calendar getData() {
        return Data;
    }

    public void setData(Calendar data) {
        Data = data;
    }

    public String getDetalii_Programare() {
        return Detalii_Programare;
    }

    public void setDetalii_Programare(String detalii_Programare) {
        Detalii_Programare = detalii_Programare;
    }

    public String getRecomandari() {
        return Recomandari;
    }

    public void setRecomandari(String recomandari) {
        Recomandari = recomandari;
    }

    public String getCNP_Client() {
        return CNP_Client;
    }

    public void setCNP_Client(String CNP_Client) {
        this.CNP_Client = CNP_Client;
    }

    public String getCNP_Medic() {
        return CNP_Medic;
    }

    public void setCNP_Medic(String CNP_Medic) {
        this.CNP_Medic = CNP_Medic;
    }

    @Override
    public String toString(){
        return CNP_Client + " " + CNP_Medic + " " + Data + " " + Detalii_Programare + " " + Recomandari;
    }
}
