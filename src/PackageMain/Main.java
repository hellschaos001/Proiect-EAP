package PackageMain;
import PackageEchipament.Echipament;
import PackageMedic.Medic;
import PackageProgramare.Programare;
import PackageReteta.Reteta;
import PackageServicii.Servicii;

import PackageClient.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        Servicii.citire_DB(Clienti, Medici, Programari, Retete, Echipamente);


        Scanner scan = new Scanner(System.in);
        int optiune=0;
        do {
            menu();
            System.out.println("Introduceti numarul actiunii:");
            optiune=scan.nextInt();

            if (optiune == 1)
            {
                //adaugare client
                Client client = Servicii.adaugare_Client();
                Clienti.put(client.getCNP(),client);
                System.out.println("Client adaugat");
            }
            if (optiune == 2)
            {
                //afisare clienti
                for(Map.Entry x: Clienti.entrySet())
                    Servicii.afisare_Client((Client) x.getValue());
            }
            if (optiune == 3)
            {
                //modificare
                System.out.println("Introduceti numele:");
                String identificator_Nume = scan.next();
                System.out.println("Introduceti prenumele:");
                String identificator_Prenume = scan.next();


                for(Map.Entry y: Clienti.entrySet())
                {
                    if(identificator_Prenume.equals( ( (Client) y.getValue() ).getPrenume() ) && identificator_Nume.equals( ((Client) y.getValue() ).getNume() ))
                    {
                        Client x = Servicii.modificare_Client();
                        Clienti.replace((String) y.getKey(),x);

                        System.out.println("Client modificat cu succes!");
                    }
                }
            }
            if (optiune == 4)
            {
                System.out.println("Introduceti numele:");
                String Nume_Stergere = scan.next();
                System.out.println("Introduceti prenumele:");
                String Prenume_Stergere = scan.next();


                for(Map.Entry y: Clienti.entrySet())
                {
                    if(Prenume_Stergere.equals( ( (Client) y.getValue() ).getPrenume() ) && Nume_Stergere.equals( ((Client) y.getValue() ).getNume() ))
                    {
                        Clienti.remove(y.getKey());
                        System.out.println("Client sters cu succes!");
                    }
                }
            }
            if (optiune == 5)
            {
                Servicii.Statistica_COVID(Clienti);
            }
            if (optiune == 6)
            {
                Servicii.afisare_Medie_Experienta(Medici);
            }
            if (optiune == 7)
            {
                Servicii.afisare_cel_mai_vechi_Medic(Medici);
            }
            if (optiune == 8)
            {
                System.out.println("Adaugare programare");

                System.out.println("CNP client:");
                String cnp_client = scan.next();
                System.out.println("CNP medic:");
                String cnp_medic= scan.next();

                Programare aux = Servicii.adaugare_Programare(cnp_client,cnp_medic);
                Programari.add(aux);
            }
            if(optiune == 9)
            {
                for(Programare z:Programari)
                {
                    Servicii.afisare_Programare(z);
                }
            }
            if(optiune == 10)
            {
                System.out.println("Valoarea Medie a echipamentelor este:" + Servicii.afisare_Valoarea_media_echipamente(Echipamente));
            }


        }while(optiune!=0);


        Servicii.scriereBD(Clienti, Medici, Programari, Retete, Echipamente);


    }
}
