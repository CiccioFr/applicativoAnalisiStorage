package inforelea.applicativoanalisistorage;

import inforelea.applicativoanalisistorage.db.Cliente;
import static inforelea.applicativoanalisistorage.db.Connessione.dbPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Francesco
 */
public class GestClienti {

    public static void putClienti(List<Cliente> clienti) {
        EntityManager db = dbPersistence();
        EntityTransaction tx = db.getTransaction();
        System.out.println("Connesione avviata");

        for (Cliente cliente : clienti) {
            System.out.println("Entro nel For della connessione");

            try {
                tx.begin();
                if (cliente.getId() == null) {
                    db.persist(cliente);
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
