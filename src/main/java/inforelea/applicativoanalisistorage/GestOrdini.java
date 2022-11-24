package inforelea.applicativoanalisistorage;

import inforelea.applicativoanalisistorage.db.Acquisto;
import static inforelea.applicativoanalisistorage.db.Connessione.dbPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Francesco
 */
public class GestOrdini {
        public static void putClienti(List<Acquisto> ordini) {
        EntityManager db = dbPersistence();
        EntityTransaction tx = db.getTransaction();
        System.out.println("Connesione avviata");

        for (Acquisto ordine : ordini) {
            System.out.println("Entro in ORDINI nel For della connessione");

            try {
                tx.begin();
                if (ordine.getId() == null) {
                    db.persist(ordine);
                }
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        }
        db.close();
    }
}
