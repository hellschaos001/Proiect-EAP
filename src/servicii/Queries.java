package servicii;

public class Queries {
    public static final String READ_PERSOANE = "SELECT CNP, nume, prenume, adresa, telefon FROM db.persoana;";
    public static final String READ_PROGRAMARI = "SELECT id_programare, data, detaliiProgramare, recomandari, CNP_C, CNP_M  FROM db.programare;";
    public static final String READ_ECHIPAMENTE = "SELECT ID_Echipament, numeProducator, telefon, numeEchipament, anProductie, pret FROM db.echipament;";
    public static final String READ_CLIENTI = "SELECT p.CNP, p.nume, p.prenume, p.adresa, p.telefon,c.asigurat,c.rezultatTestCOVID,c.salariat,c.boli,c.alergeni,c.grupaSange  FROM db.persoana p\n" +
            "join db.client c\n" +
            "on c.CNP_C = p.CNP;";
    public static final String READ_MEDICI = "SELECT p.CNP, p.nume, p.prenume, p.adresa, p.telefon,m.specializare,m.aniExperienta,m.dataAngajarii  FROM db.persoana p\n" +
            "join db.medic m\n" +
            "on m.CNP_M = p.CNP;";

    public static final String INSERT_NEW_ECHIPAMENT = "INSERT INTO echipament(ID_Echipament, numeProducator, telefon, numeEchipament, anProductie, pret) values (null,?,?,?,?,?,?,?)";
    public static final String INSERT_NEW_PERSOANA = "INSERT INTO persoana(CNP, nume, prenume, adresa, telefon) values (?,?,?,?,?)";
    public static final String INSERT_NEW_CLIENT = "INSERT INTO client(CNP_C, asigurat, rezultatTestCOVID, salariat, boli, alergeni, grupaSange) values (?,?,?,?,?,?,?)";
    public static final String INSERT_NEW_MEDIC = "INSERT INTO medic(CNP_M, specializare, dataAngajarii, aniExperienta) values (?,?,?,?)";
    public static final String INSERT_NEW_PROGRAMARE = "INSERT INTO programare(id_programare, data, detaliiProgramare, recomandari, CNP_C, CNP_M) values (null,?,?,?,?,?)";

    public static final String UPDATE_PERSOANA = "UPDATE persoana SET CNP = ?, NUME = ?, PRENUME = ?, ADRESA = ?, TELEFON = ? WHERE CNP =?";
    public static final String UPDATE_CLIENT = "UPDATE client SET  CNP_C = ?, asigurat = ? , rezultatTestCOVID = ?, salariat = ?, boli = ?, alergeni = ?, grupaSange = ? WHERE CNP_C = ?";
    public static final String UPDATE_MEDIC = "UPDATE medic SET specializare = ?, dataAngajarii = ?, aniExperienta = ?, CNP_M = ? WHERE CNP_M = ?";

    public static final String DELETE_PERSOANA = "DELETE FROM persoana WHERE CNP = ?";
    public static final String DELETE_CLIENT = "DELETE FROM client WHERE CNP_C = ?";
    public static final String DELETE_MEDIC = "DELETE FROM medic WHERE CNP_M = ?";
    public static final String DELETE_PROGRAMARE = "DELETE FROM programare WHERE cnp_c = ? and cnp_m = ?";
}
