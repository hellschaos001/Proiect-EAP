package servicii;
import echipament.Producator;
import persoana.Client;
import echipament.Echipament;
import persoana.Medic;
import medicament.Medicament;
import persoana.Programare;
import medicament.Reteta;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*; //Connection, Statement, ResultSet
import java.util.*;//random,scaner,arraylist,HashMap,etc.
import java.lang.*;//math.etc
import java.text.SimpleDateFormat;
import java.util.Date;

import static servicii.Queries.*;


public class Servicii {
    private static DbConnection dbConnection = DbConnection.getInstance();

    //1)Adaugare Client
    public static Client adaugareClient() {
        Client x = new Client();

        Scanner scan = new Scanner(System.in);

        System.out.println("CNP:");
        x.setCnp(scan.nextLine());

        System.out.println("Nume:");
        x.setNume(scan.nextLine());

        System.out.println("Prenume:");
        x.setPrenume(scan.nextLine());

        System.out.println("Adresa:");
        x.setAdresa(scan.nextLine());

        System.out.println("Telefon:");
        x.setTelefon(scan.nextLine());

        System.out.println("Clientul este asigurat?(da/nu)");
        String asigurat = scan.nextLine().toLowerCase(Locale.ROOT);
        if(asigurat.equals("da"))
            x.setAsigurat(true);
        else
            x.setAsigurat(false);

        System.out.println("Rezultatul testului COVID al clientului?(Pozitiv/Negativ)");
        String TestCovid = scan.nextLine().toLowerCase(Locale.ROOT);
        if(TestCovid.equals("pozitiv"))
            x.setRezultatTestCOVID(true);
        else
            x.setRezultatTestCOVID(false);

        System.out.println("Clientul este Salariat?(da/nu)");
        String Salariat = scan.nextLine().toLowerCase(Locale.ROOT);
        if(Salariat.equals("da"))
            x.setSalariat(true);
        else
            x.setSalariat(false);

        System.out.println("Boli:");
        x.setBoli(scan.nextLine());

        System.out.println("Alergeni:");
        x.setAlergeni(scan.nextLine());

        System.out.println("Grupa sange:");
        x.setGrupaSange(scan.nextLine());


        return x;
    }

    //Scriere din fisere
    public static void scriereCSV(HashMap<String, Client> Clienti,
                                  HashMap<String, Medic> Medici,
                                  ArrayList<Programare> Programari,
                                  ArrayList<Reteta> Retete,
                                  ArrayList<Echipament> Echipamente) throws IOException {

FileWriter scriereClient = new FileWriter("Baza de date/ClientDB.csv");
scriereClient.write("cnp,nume,prenume,adresa,telefon,asigurat,rezultatTestCOVID,salariat,boli,alergeni,grupaSange"+"\n");
for(Map.Entry x: Clienti.entrySet())
{
scriereClient.write(((Client) x.getValue()).getCnp()
        +","+((Client) x.getValue()).getNume()
        +","+((Client) x.getValue()).getPrenume()
        +","+ ((Client) x.getValue()).getAdresa()
        +","+ ((Client) x.getValue()).getTelefon()
        +","+((Client) x.getValue()).isAsigurat()
        +","+((Client) x.getValue()).isRezultatTestCOVID()
        +","+ ((Client) x.getValue()).isSalariat()
        +","+((Client) x.getValue()).getBoli()
        +","+((Client) x.getValue()).getAlergeni()
        +","+((Client) x.getValue()).getGrupaSange()+"\n");
}
scriereClient.close();


FileWriter scriereMedic = new FileWriter("Baza de date/MedicDB.csv");
scriereMedic.write("cnp,nume,prenume,adresa,telefon,specializare,aniExperienta,dataAngajarii\n");
for(Map.Entry x: Medici.entrySet())
{
scriereMedic.write(((Medic) x.getValue()).getCnp()
        +","+((Medic) x.getValue()).getNume()
        +","+((Medic) x.getValue()).getPrenume()
        +","+((Medic) x.getValue()).getAdresa()
        +","+((Medic) x.getValue()).getTelefon()
        +","+((Medic) x.getValue()).getSpecializare()
        +","+((Medic) x.getValue()).getAniExperienta()
        +","+((Medic) x.getValue()).getDataAngajarii().get(Calendar.DATE)
        +","+(((Medic) x.getValue()).getDataAngajarii().get(Calendar.MONTH)+1)
        +","+((Medic) x.getValue()).getDataAngajarii().get(Calendar.YEAR)+"\n");
}
scriereMedic.close();

FileWriter scriereEchipament = new FileWriter("Baza de date/EchipamentDB.csv");
scriereEchipament.write("numeProducator,telefon,numeEchipament,anProductie,pret\n");
for(Echipament x:Echipamente)
{
scriereEchipament.write(x.getProducator().getNumeProducator()
    +","+x.getProducator().getTelefon()
    +","+x.getNumeEchipament()
    +","+x.getAnProductie()
    +","+x.getPret()+"\n");
}
scriereEchipament.close();

FileWriter scriereProgramare = new FileWriter("Baza de date/ProgramareDB.csv");
scriereProgramare.write("zi,luna,an,ora,minute,detaliiProgramare,recomandari,cnpClient,cnpMedic\n");
for(Programare x:Programari)
scriereProgramare.write(x.getData().get(Calendar.DATE) +","
    + (x.getData().get(Calendar.MONTH)+1)
    + "," + x.getData().get(Calendar.YEAR)
    + ","  + x.getData().get(Calendar.HOUR)
    + ","  + x.getData().get(Calendar.MINUTE)
    + ","  + x.getDetaliiProgramare()
    + ","  + x.getRecomandari()
    + ","  + x.getCnpClient()
    + ","  + x.getCnpMedic()+"\n");
scriereProgramare.close();

FileWriter scriereReteta = new FileWriter("Baza de date/RetetaDB.csv");

scriereReteta.write("durata,listaMedicamente(denumire;modAdministrare;prospect)\n");
for(Reteta x:Retete) {
    String str = new String("");
    HashMap<String, Medicament> lista_medicamente = x.getListaMedicamente();
for (Map.Entry y : lista_medicamente.entrySet()) {
    str+=(((Medicament) y.getValue()).getDenumire() + ";" +
            ((Medicament) y.getValue()).getModAdministrare() + ";" +
            ((Medicament) y.getValue()).getProspect())+ ";";
}
str=str.substring(0,str.length()-1);
scriereReteta.write(x.getDurata() + "," + str+"\n");
}
scriereReteta.close();
}
    //Citirea din fisiere
    public static  void citireCSV(HashMap<String, Client> Clienti,
                                  HashMap<String, Medic> Medici,
                                  ArrayList<Programare> Programari,
                                  ArrayList<Reteta> Retete,
                                  ArrayList<Echipament> Echipamente){

        /*try {
            File fisier_client = new File("Baza de date/ClientDB.csv");
            Scanner myReader = new Scanner(fisier_client);
            if(myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Client client = new Client();
                client.setCnp(arg_of_Data[0]);
                client.setNume(arg_of_Data[1]);
                client.setPrenume(arg_of_Data[2]);
                client.setAdresa(arg_of_Data[3]);
                client.setTelefon(arg_of_Data[4]);
                client.setAsigurat(Boolean.parseBoolean(arg_of_Data[5]));
                client.setRezultatTestCOVID(Boolean.parseBoolean(arg_of_Data[6]));
                client.setSalariat(Boolean.parseBoolean(arg_of_Data[7]));
                client.setBoli(arg_of_Data[8]);
                client.setAlergeni(arg_of_Data[9]);
                client.setGrupaSange(arg_of_Data[10]);
                Clienti.put(arg_of_Data[0],client);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul ClientDB.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_echipament = new File("Baza de date/EchipamentDB.csv");
            Scanner myReader = new Scanner(fisier_echipament);
            if(myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Echipament echipament = new Echipament();
                Producator producator = new Producator();
                producator.setNumeProducator(arg_of_Data[0]);
                producator.setTelefon(arg_of_Data[1]);
                echipament.setProducator(producator);
                echipament.setNumeEchipament(arg_of_Data[2]);
                echipament.setAnProductie(Integer.parseInt(arg_of_Data[3]));
                echipament.setPret(Float.parseFloat(arg_of_Data[4]));
                Echipamente.add(echipament);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul EchipamentDB.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_medic = new File("Baza de date/MedicDB.csv");
            Scanner myReader = new Scanner(fisier_medic);
            if(myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Medic medic = new Medic();
                medic.setCnp(arg_of_Data[0]);
                medic.setNume(arg_of_Data[1]);
                medic.setPrenume(arg_of_Data[2]);
                medic.setAdresa(arg_of_Data[3]);
                medic.setTelefon(arg_of_Data[4]);
                medic.setSpecializare(arg_of_Data[5]);
                medic.setAniExperienta(Integer.parseInt(arg_of_Data[6]));
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(arg_of_Data[9]),Integer.parseInt(arg_of_Data[8]),Integer.parseInt(arg_of_Data[7]));
                medic.setDataAngajarii(cal);
                Medici.put(arg_of_Data[0],medic);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul MedicDB.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_programare = new File("Baza de date/ProgramareDB.csv");
            Scanner myReader = new Scanner(fisier_programare);
            if(myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Programare programare = new Programare();
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(arg_of_Data[2]),Integer.parseInt(arg_of_Data[1]),Integer.parseInt(arg_of_Data[0]),Integer.parseInt(arg_of_Data[3]),Integer.parseInt(arg_of_Data[4]));
                programare.setData(cal);
                programare.setDetaliiProgramare(arg_of_Data[5]);
                programare.setRecomandari(arg_of_Data[6]);
                programare.setCnpClient(arg_of_Data[7]);
                programare.setCnpMedic(arg_of_Data[8]);
                Programari.add(programare);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul ProgramareDB.csv nu a fost gasit!!!");
            e.printStackTrace();
        }*/

        try {
            File fisier_reteta = new File("Baza de date/RetetaDB.csv");
            Scanner myReader = new Scanner(fisier_reteta);
            if(myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Reteta reteta = new Reteta();
                HashMap<String, Medicament> mapMedicamente = new HashMap<>();
                reteta.setDurata(arg_of_Data[0]);
                String[] medicamente = arg_of_Data[1].split(";");

                for( int i=0;i<medicamente.length/3;++i)
                {
                    Medicament medicament = new Medicament();
                    medicament.setDenumire(medicamente[3*i]);
                    medicament.setModAdministrare(medicamente[3*i+1]);
                    medicament.setProspect(medicamente[3*i+2]);
                    mapMedicamente.put(medicament.getDenumire(),medicament);
                }
                reteta.setListaMedicamente(mapMedicamente);
                Retete.add(reteta);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul Reteta_DataBase.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

    }

    //2) Afisare Client
    public static void afisareClient(Client x){
        System.out.println("CNP: "+" "+x.getCnp());
        System.out.println("Nume Prenume: "+x.getNume()+" "+x.getPrenume());
        System.out.println("Adresa: "+ " "+x.getAdresa());
        System.out.println("Telefon: "+ " "+x.getTelefon());

        if(x.isAsigurat())
            System.out.println("Asigurat: Da");
        else
            System.out.println("Asigurat: Nu");

        if(x.isRezultatTestCOVID())
            System.out.println("Rezultat test COVID: POZITIV");
        else
            System.out.println("Rezultat test COVID: NEGATIV");

        if(x.isSalariat())
            System.out.println("Salariat: Da");
        else
            System.out.println("Salariat: Nu");

        System.out.println("Boli: "+x.getBoli());
        System.out.println("Alergeni: "+ " "+x.getAlergeni());
        System.out.println("Grupa sange: "+ " "+x.getGrupaSange());
        System.out.println("----------");
    }

    //3) Modificare Client
    public static Client modificareClient() {

        Client x = new Client();

        Scanner scan = new Scanner(System.in);

        System.out.println("CNP:");
        x.setCnp(scan.nextLine());

        System.out.println("Nume:");
        x.setNume(scan.nextLine());

        System.out.println("Prenume:");
        x.setPrenume(scan.nextLine());

        System.out.println("Adresa:");
        x.setAdresa(scan.nextLine());

        System.out.println("Telefon:");
        x.setTelefon(scan.nextLine());

        System.out.println("Clientul este asigurat?(da/nu)");
        String asigurat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setAsigurat(asigurat.equals("da"));

        System.out.println("Rezultatul testului COVID al clientului?(Pozitiv/Negativ)");
        String TestCovid = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setRezultatTestCOVID(TestCovid.equals("pozitiv"));

        System.out.println("Clientul este Salariat?(da/nu)");
        String Salariat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setSalariat(Salariat.equals("da"));

        System.out.println("Boli:");
        x.setBoli(scan.nextLine());

        System.out.println("Alergeni:");
        x.setAlergeni(scan.nextLine());

        System.out.println("Grupa sange:");
        x.setGrupaSange(scan.nextLine());

        return x;
    }

    //5 Afisare numar clienti COVID
    public static void statisticaCOVID(HashMap<String,Client> list) {
        float procentaj = 0;
        int nrTotal=0;
        int nrCovid=0;
        for(Map.Entry x: list.entrySet())
        {
            nrTotal++;
           if(((Client)x.getValue()).isRezultatTestCOVID())
               nrCovid++;
        }
        procentaj=(float)nrCovid/nrTotal*100;

        System.out.println("Procentajul de clienti ce au COVID:" + procentaj);
    }

    //6)Afisare Medie ani experienta Medici
    public static void afisareMedieExperienta(HashMap<String,Medic> list){
        int count=0;
        int ani_experienta=0;
        for(Map.Entry x:list.entrySet()) {
            ani_experienta+=((Medic)x.getValue()).getAniExperienta();
            ++count;
        }
        System.out.println("Media de experienta a medicilor: "+(float)ani_experienta/count+" ani");
    }

    //7)Cel mai vechi angajat (Medic)
    public static void afisareCelMaiVechiMedic(HashMap<String,Medic> list) {
        Calendar minDate=Calendar.getInstance();

        String Nume="", Prenume="", Specializare="";

        for(Map.Entry x:list.entrySet())
        {
            if(minDate.after(((Medic)x.getValue()).getDataAngajarii()))
            {
                minDate = ((Medic)x.getValue()).getDataAngajarii();
                Nume=((Medic)x.getValue()).getNume();
                Prenume=((Medic)x.getValue()).getPrenume();
                Specializare=((Medic)x.getValue()).getSpecializare();
            }

        }
        if(Nume.equals("") && Prenume.equals("") && Specializare.equals(""))
            System.out.println("Nu exista cel mai vechi medic angajat:");
        else
            System.out.println("Cel mai vechi medic angajat este:"+ Nume + " " + Prenume + " " + Specializare);
    }

    //8)Adaugare programare
    public static Programare adaugareProgramare(String cnp_client, String cnp_medic) {
        Programare x = new Programare();
        Scanner scan = new Scanner(System.in);
        int zi,luna,an,ora,minut;

        x.setCnpClient(cnp_client);
        x.setCnpMedic(cnp_medic);

        System.out.println("Data Programari:");
        System.out.println("Ziua:");
        zi=scan.nextInt();
        System.out.println("Luna:");
        luna=scan.nextInt();
        System.out.println("Anul:");
        an=scan.nextInt();
        System.out.println("Ora:");
        ora=scan.nextInt();
        System.out.println("Minutul:");
        minut=scan.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(an,luna,zi,ora,minut);
        x.setData(cal);

        System.out.print("Detalii Programare:");
        scan.nextLine();
        x.setDetaliiProgramare(scan.nextLine());

        System.out.print("Recomandari:");
        x.setRecomandari(scan.nextLine());

        return x;
    }

    //9Afisare programari
    public static void afisareProgramare(Programare x) {

        System.out.println("Data Programarii este: Ziua" + x.getData().get(Calendar.DATE) + " Luna "+ (x.getData().get(Calendar.MONTH)+1) + " Anul " + x.getData().get(Calendar.YEAR) + " Ora "  + x.getData().get(Calendar.HOUR) + " Minutul "  + x.getData().get(Calendar.MINUTE));
        System.out.println("Detalii Programare: " + x.getDetaliiProgramare());
        System.out.println("Recomandari: " + x.getRecomandari());
        System.out.println("CNP Client: " + x.getCnpClient());
        System.out.println("CNP Medic: " + x.getCnpMedic());

    }

    //10)Afisare Valoarea Medie a echipamentelor
    public static float afisareValoareaMediaEchipamente(ArrayList<Echipament> list) {
        int count=0;
        float valoare=0;
        for(Echipament it:list)
        {
            ++count;
            valoare+=it.getPret();
        }

        return (float)valoare/count;
    }

    //COMENZI APLICATE PE BAZA DE DATE
    //11)Afisare echipament DB
    public static void CreareTabelTest(){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","ciscosecpa55");
            Statement stmt = conn.createStatement();
        ){
            String strSelect = "SELECT * FROM echipament";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;

            while(rset.next()) {
                String numeEchipament = rset.getString("numeEchipament");
                int anProductie = rset.getInt("anProductie");
                int pret = rset.getInt("pret");
                String numeProducator = rset.getString("numeProducator");
                int telefon = rset.getInt("telefon");
                int ID_Echipament = rset.getInt("ID_Echipament");

                System.out.println(numeEchipament +","+ anProductie +","+ pret +","+ numeProducator +","+ telefon +","+ ID_Echipament +"\n");
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    private static long calendarToDate(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    private static Calendar timeStampToCalendar(Timestamp date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    private static long calendarToTimeStamp(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    //11 Citire din baza de date
    public static void citireDB(HashMap<String, Client> Clienti,
                                HashMap<String, Medic> Medici,
                                ArrayList<Programare> Programari,
                                ArrayList<Echipament> Echipamente){
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_CLIENTI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),resultSet.getBoolean(7),resultSet.getBoolean(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11) );
                Clienti.put(resultSet.getString(1),client);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_MEDICI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Medic medic = new Medic(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getInt(7),dateToCalendar(resultSet.getDate(8)));
                Medici.put(resultSet.getString(1),medic);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_PROGRAMARI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Programare programari = new Programare(timeStampToCalendar(resultSet.getTimestamp(2)), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                Programari.add(programari);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_ECHIPAMENTE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Echipament echipament = new Echipament(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5),resultSet.getFloat(6));
                Echipamente.add(echipament);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Adaugare Client in BD
    public static void adaugareClient(Client client)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setString(2, client.getNume());
            preparedStatement.setString(3, client.getPrenume());
            preparedStatement.setString(4, client.getAdresa());
            preparedStatement.setString(5, client.getTelefon());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea clientului");
        }
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_CLIENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setBoolean(2, client.isAsigurat());
            preparedStatement.setBoolean(3, client.isRezultatTestCOVID());
            preparedStatement.setBoolean(4, client.isSalariat());
            preparedStatement.setString(5, client.getBoli());
            preparedStatement.setString(6, client.getAlergeni());
            preparedStatement.setString(7, client.getGrupaSange());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea clientului");
        }
    }
    //Adaugare Medic in BD
    public static void adaugareMedic(Medic medic)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getNume());
            preparedStatement.setString(3, medic.getPrenume());
            preparedStatement.setString(4, medic.getAdresa());
            preparedStatement.setString(5, medic.getTelefon());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding library");
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_MEDIC, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getSpecializare());
            preparedStatement.setInt(3, medic.getAniExperienta());
            preparedStatement.setDate(4, new java.sql.Date(calendarToDate(medic.getDataAngajarii())));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea medicului");
        }
    }
    //Adaugare Programare in BD
    public static void adaugareProgramare(Programare programare)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_PROGRAMARE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(calendarToTimeStamp(programare.getData())));
            preparedStatement.setString(2, programare.getDetaliiProgramare());
            preparedStatement.setString(3, programare.getRecomandari());
            preparedStatement.setString(4, programare.getCnpClient());
            preparedStatement.setString(5, programare.getCnpMedic());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea programarii");
        }
    }
    //Adaugare Echipament in BD
    public static void adaugareEchipament(Echipament echipament)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_ECHIPAMENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, echipament.getProducator().getNumeProducator());
            preparedStatement.setString(2, echipament.getProducator().getTelefon());
            preparedStatement.setString(3, echipament.getNumeEchipament());
            preparedStatement.setInt(4, echipament.getAnProductie());
            preparedStatement.setFloat(5, echipament.getPret());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea echipamentului");
        }
    }
    //Update Client in BD
    public static void updateClient(String cnp,Client client)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setString(2, client.getNume());
            preparedStatement.setString(3, client.getPrenume());
            preparedStatement.setString(4, client.getAdresa());
            preparedStatement.setString(5, client.getTelefon());
            preparedStatement.setString(6, cnp);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la modificarea unei persoane");
        }
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_CLIENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setBoolean(2, client.isAsigurat());
            preparedStatement.setBoolean(3, client.isRezultatTestCOVID());
            preparedStatement.setBoolean(4, client.isSalariat());
            preparedStatement.setString(5, client.getBoli());
            preparedStatement.setString(6, client.getAlergeni());
            preparedStatement.setString(7, client.getGrupaSange());
            preparedStatement.setString(8, client.getCnp());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("\"S-a detectat o problema la modificarea unui client");
        }
    }
    //Update Medic in BD
    public static void updateMedic(String cnp,Medic medic)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getNume());
            preparedStatement.setString(3, medic.getPrenume());
            preparedStatement.setString(4, medic.getAdresa());
            preparedStatement.setString(5, medic.getTelefon());
            preparedStatement.setString(6, cnp);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding library");
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_MEDIC, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getSpecializare());
            preparedStatement.setInt(3, medic.getAniExperienta());
            preparedStatement.setDate(4, new java.sql.Date(calendarToDate(medic.getDataAngajarii())));
            preparedStatement.setString(5, medic.getCnp());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea medicului");
        }
    }
    //Delete Client din BD
    public static void deletePersoana(String cnp)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cnp);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la stergerea unei persoane");
        }
    }
    //Delete Programare din BD
    public static void deleteProgramare(String cnp_c,String cnp_m)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_PROGRAMARE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cnp_c);
            preparedStatement.setString(2, cnp_m);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Serviciu de audit
    public static void audit(String numeActiune)throws IOException
    {
        FileWriter scriereAudit = new FileWriter("Baza de date/audit.csv",true);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        scriereAudit.write(numeActiune + "," +formatter.format(date) + "\n");
        scriereAudit.close();
    }

}

