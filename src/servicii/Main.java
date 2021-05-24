package servicii;
import echipament.Echipament;
import persoana.Medic;
import persoana.Programare;
import medicament.Reteta;

import persoana.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void menu(){
        System.out.println("Preda Alexandru-Florin /// Grupa 253 /// EAP");
        System.out.println("--Programari cabinet medical");
        System.out.println("Optiuni:");
        System.out.println("1.Adaugare Client");
        System.out.println("2.Afisare  Clienti");
        System.out.println("3.Modificare Client");
        System.out.println("4.Stergere Client");
        System.out.println("5.Procentaj clienti cu  COVID");
        System.out.println("6.Afisare medie ani experienta Medici");
        System.out.println("7.Cel mai vechi angajat (Medic)");
        System.out.println("8.Adaugare programare");
        System.out.println("9.Afisare programare");
        System.out.println("10.Afisarea Valoarii Medie a echipamentelor");
        System.out.println("0. Iesire");
    }

    public static void main(String[] args) throws IOException {

        HashMap<String, Client> Clienti = new HashMap<>();
        HashMap<String, Medic> Medici = new HashMap<>();
        ArrayList<Programare> Programari = new ArrayList<>();
        ArrayList<Reteta> Retete = new ArrayList<>();
        ArrayList<Echipament> Echipamente = new ArrayList<>();

        Servicii.citireDB(Clienti, Medici, Programari, Retete, Echipamente);

        //Testare Servicii SDBC
        Servicii.deleteProgramare("100", "200");
        Scanner scan = new Scanner(System.in);
        int optiune=0;
        do {
            menu();
            System.out.println("Introduceti numarul actiunii:");
            optiune=scan.nextInt();

            if (optiune == 1)
            {
                //adaugare client
                Client client = Servicii.adaugareClient();
                Clienti.put(client.getCnp(),client);
                System.out.println("Client adaugat");
                Servicii.audit("Adaugare client");
                Servicii.audit("Client adaugat");
                Servicii.adaugareClient(client);
            }
            if (optiune == 2)
            {
                //afisare clienti
                for(Map.Entry x: Clienti.entrySet())
                    Servicii.afisareClient((Client) x.getValue());
                Servicii.audit("Afisare clienti");
            }
            if (optiune == 3)
            {
                //modificare
                System.out.println("Introduceti CNP:");
                String identificatorCnp = scan.next();
                if(Clienti.containsKey(identificatorCnp))
                {
                    Client a = Servicii.modificareClient();
                    Clienti.remove(identificatorCnp);
                    Clienti.put(a.getCnp(), a);
                    Servicii.updateClient(identificatorCnp, a);
                    Servicii.audit("Modificare clienti");
                }
                else System.out.println("Nu exista un client cu acest CNP!!!");

            }
            if (optiune == 4)
            {
                System.out.println("Introduceti cnp:");
                String cnp = scan.next();

                if(Clienti.containsKey(cnp))
                {
                    Client a = Servicii.modificareClient();
                    Clienti.remove(cnp);
                    Servicii.deletePersoana(cnp);
                    Servicii.audit("Stergere persoana");
                }
                else System.out.println("Nu exista persoana cu acest CNP!!!");
            }
            if (optiune == 5)
            {
                Servicii.statisticaCOVID(Clienti);
                Servicii.audit("statistica covid");
            }
            if (optiune == 6)
            {
                Servicii.afisareMedieExperienta(Medici);
                Servicii.audit("medie experienta medici");
            }
            if (optiune == 7)
            {
                Servicii.afisareCelMaiVechiMedic(Medici);
                Servicii.audit("cel mai vechi medic");
            }
            if (optiune == 8)
            {
                System.out.println("Adaugare programare");

                System.out.println("CNP client:");
                String cnp_client = scan.next();
                System.out.println("CNP medic:");
                String cnp_medic= scan.next();

                Programare aux = Servicii.adaugareProgramare(cnp_client,cnp_medic);
                Programari.add(aux);
                Servicii.audit("adaugare programare");
            }
            if(optiune == 9)
            {
                for(Programare z:Programari)
                {
                    Servicii.afisareProgramare(z);
                }
                Servicii.audit("afisare programare");
            }
            if(optiune == 10)
            {
                System.out.println("Valoarea Medie a echipamentelor este:" + Servicii.afisareValoareaMediaEchipamente(Echipamente));
                Servicii.audit("valoare medie a echipamentelor");
            }
        }while(optiune!=0);


        Servicii.scriereBD(Clienti, Medici, Programari, Retete, Echipamente);
    }

}
