package DAOs;

import Entities.Admin;
import Entities.Librarian;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class AdminDAO {
    EntityManager entityManager;

    public AdminDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
@SuppressWarnings("unchecked")
    public boolean login(Admin admin) {
        try {
            List<Admin> adminList = entityManager.createNamedQuery("authenticateAdmin").setParameter("mail", admin.getEmail()).setParameter("pass", admin.getPassword()).getResultList();

            return adminList.size() > 0;
        } catch (PersistenceException px) {
            px.printStackTrace();
            return false;

        }
    }
}
