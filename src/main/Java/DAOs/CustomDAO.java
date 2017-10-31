package DAOs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class CustomDAO<T> {
    EntityManager entityManager;

    public CustomDAO(
            EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public  boolean addCustom(T t){
        try{
            entityManager.persist(t);
            return  true;
        }catch (PersistenceException ex) {
            ex.printStackTrace();
            return  false;
        }
    }
}
