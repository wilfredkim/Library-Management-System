package DAOs;

import Entities.Librarian;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class LibrarianLoginDAO {
    EntityManager entityManager;

    public LibrarianLoginDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    public boolean login(Librarian librarian) {
        try {
            List<Librarian> librarians = entityManager.createNamedQuery("authenticateLibrarian").setParameter("mail", librarian.getEmail()).setParameter("pass", librarian.getPassword()).getResultList();

            return librarians.size() > 0;
        } catch (PersistenceException px) {
            px.printStackTrace();
            return false;

        }
    }


}
