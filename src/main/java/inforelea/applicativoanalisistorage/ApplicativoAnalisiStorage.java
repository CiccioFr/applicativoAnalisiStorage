package inforelea.applicativoanalisistorage;

import inforelea.applicativoanalisistorage.db.Cliente;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Francesco
 */
public class ApplicativoAnalisiStorage {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Operazioni disponibili:"
                + "\nScrivere 1 per: Carica file di log e Salva su DataBase clienti e ordini"
                + "\nScrivere 2 per: visualiza gli ordinativi eseguiti da un dato cliente ");
        int sceltaUtente = tastiera.nextInt();
        tastiera.nextLine();

        switch (sceltaUtente) {
            case 1:
                System.out.println("Inserisci percorso e file Log da caricare"
                        + "\n    -> suggerito \"ordini.log\"");

                List recordsDelLog = CaricaFileLog.leggiLog(tastiera.nextLine());
                System.out.println(" 1)  File Letto, - Creo la Lista di clienti");

                List<Cliente> clienti = CaricaFileLog.listaClienti(recordsDelLog);
                System.out.println(" 2)  Lista di clienti creata -> Li salvo di DataBase");

                GestClienti.putClienti(clienti);

                break;
            case 2:

                break;
            default:
                System.out.println("Scelta non valida");
        }

    }
}
