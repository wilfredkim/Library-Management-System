package DAOs;

import Entities.Librarian;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import java.util.ArrayList;
import java.util.List;

public class LibrarianDAO  extends  CustomDAO<Librarian> {


    public LibrarianDAO(EntityManager entityManager) {
        super(entityManager);
    }



    public boolean addLibrarian(Librarian librarian) {
        return  this.addCustom(librarian);
    }
@SuppressWarnings("unchecked")
    public ArrayList<Librarian> viewLibrarian() {
        try{
             return (ArrayList<Librarian>) entityManager.createNamedQuery("viewAll").getResultList();
        }catch (PersistenceException px){
            px.printStackTrace();
            return  null;
        }
    }

    public boolean deleteLibrarian(Librarian librarian) {
        try{
          int delete =  entityManager.createNamedQuery("deleteLibrarian").setParameter("num",librarian.getWorkNumber()).executeUpdate();
          if(delete>0){
              return  true;
          }  else {
              return  false;
          }
        }catch (PersistenceException px) {
            px.printStackTrace();
            return false;
        }
    }
}
