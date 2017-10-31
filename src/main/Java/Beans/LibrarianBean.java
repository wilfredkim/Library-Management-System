package Beans;

import DAOs.LibrarianDAO;
import Entities.AuditTrail;
import Entities.Librarian;
import Events.AuditTrailEvent;
import Interfaces.LibrarianI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;

@Stateless
@Local
public class LibrarianBean implements LibrarianI {
    @PersistenceContext
    EntityManager entityManager;



    public boolean addLibrarian(Librarian librarian) {
        LibrarianDAO librarianDAO = new LibrarianDAO(entityManager);
        return  librarianDAO.addLibrarian(librarian);
    }

    public ArrayList<Librarian> viewLibrarian() {
        LibrarianDAO librarianDAO = new LibrarianDAO(entityManager);
       return   librarianDAO.viewLibrarian();
    }

    public boolean deleteLibrarian(Librarian librarian) {
        LibrarianDAO librarianDAO = new LibrarianDAO(entityManager);
        return  librarianDAO.deleteLibrarian(librarian);
    }


}
