package inforelea.applicativoanalisistorage;

import inforelea.applicativoanalisistorage.db.Acquisto;
import inforelea.applicativoanalisistorage.db.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francesco
 */
public class CaricaFileLog {

    /**
     * Carica in List il contenuto di fule Log a scelta dell'utente
     *
     * @param percorsoFile path/filename del fiel da caricare
     * @return List del contenuto del file
     */
    public static List<String[]> leggiLog(String percorsoFile) {
        String line = "";
        List<String[]> records = new ArrayList();
        final String PIPE = "\\|";

        try {
            String filePath = percorsoFile;
            FileReader fileReader = new FileReader(filePath);
            if (fileReader.equals(null)) {
                System.out.println("File non trovato."
                        + "    --   ESCO!!!   --");
                return null;
//                System.exit(1, "file non trovato");
            }

            BufferedReader reader = new BufferedReader(fileReader);
            System.out.println(reader.readLine());
            while ((line = reader.readLine()) != null) {
                System.out.println("Stampo ogni linea del file: " + line);  // feedback
                String[] record = line.split(PIPE);
//                String[] record = record2(line);
                System.out.println("Stampo ogni linea TRASFORMATA: " + record[2] + "\n\n");  // feedback  OK
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Tra le righe della lista fornita come parametro d'ingresso, prendo in
     * considerazione solo quelle dei clienti rigistrati
     *
     * @param records List del file log
     */
    public static List<Cliente> salvaClienti(List<String[]> records) {
        List<Cliente> clienti = new ArrayList();
        int cnt = 0;

        for (String[] record : records) {
            System.out.println("Leggo record della lista" + record[1]);   // OK
            if (record[1].equalsIgnoreCase("REGISTRAZIONE")) {
//                System.out.println("Leggo singolo REGISTRAZIONE della lista");   // feedback OK
                Cliente cliente = new Cliente();
                String[] datoKeyValue = null;
                cnt++;

                cliente.setTimestamp(record[0]);

                String[] datiPersonaliCliente = record[2].split(",");
                System.out.println("dato Cliente" + datiPersonaliCliente[0]);       //  feedback
                String[] infoCodice = datiPersonaliCliente[0].split("=");
                String[] infoNome = datiPersonaliCliente[1].split("=");
                String[] infoCognome = datiPersonaliCliente[2].split("=");
                
                cliente.setCodice(Integer.parseInt(infoCodice[1]));
                cliente.setNome(infoNome[1]);
                cliente.setCognome( infoCognome[1] );
                
                clienti.add(cliente);
            }
        }
        System.out.println("Trovati " + cnt + " Clienti");
        return clienti;
    }

    public static List<Acquisto> salvaOrdini(List<String[]> records) {
        List<Acquisto> ordini = new ArrayList();
        int cnt = 0;

        for (String[] record : records) {
            System.out.println("Leggo record della lista" + record[1]);   // OK
            if (record[1].equalsIgnoreCase("ACQUISTO")) {
                Acquisto ordine = new Acquisto();
                String[] datoKeyValue = null;
                cnt++;

                ordine.setTimestamp(record[0]);

                String[] datiOrdine = record[2].split(",");
                System.out.println("dato Cliente" + datiOrdine[0]);       //  feedback
                //String[] infoId = datiOrdine[0].split("=");
                String[] infoIdCliente = datiOrdine[1].split("=");
                String[] infoImporto = datiOrdine[2].split("=");
                String[] infoProdotto = datiOrdine[2].split("=");
                
                ordine.setIdcliente(Integer.parseInt(infoIdCliente[1]) );
                ordine.setImporto(Integer.parseInt(infoImporto[1]) );
                ordine.setProdotto(Integer.parseInt(infoProdotto[1]) );
                
                ordini.add(ordine);
            }
        }
        System.out.println("Trovati " + cnt + " Ordini");
        return ordini;
    }
    
//
//
//
//
//
//    private static String[] datiSensibliCliente(String[] datiPersonaliCliente) {
////        String[] datoKeyValue;
//        Map<String, String> datoKeyValue = new HashMap<String, String>();
//
//        for (String string : datiPersonaliCliente) {
//            String[] dato = string.trim().split("=");
//            datoKeyValue.put(dato[0], dato[1]);
//            
//            
//            datoKeyValue.get("codice");
//            datoKeyValue.get("nome");
//            datoKeyValue.get("cognome");
//            
//            
////            cliente.setCodice(Integer.parseInt(datoKeyValue[1]));
////            cliente.setNome(datoKeyValue[1]);
////            cliente.setCognome(datoKeyValue[1]);
//        }
//        return null;
//    }
    private static String[] record2(String line) {
        String[] record = new String[3];
        int idx1 = line.indexOf("|");
        int idx2 = line.indexOf("|", idx1 + 1);
        record[0] = line.substring(0, idx1);
        record[1] = line.substring(idx1 + 1, idx2);
        record[2] = line.substring(idx2 + 1);

        return record;
    }
}
