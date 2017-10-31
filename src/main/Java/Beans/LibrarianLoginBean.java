package Beans;

import DAOs.LibrarianDAO;
import DAOs.LibrarianLoginDAO;
import Entities.AuditTrail;
import Entities.Librarian;
import Events.AuditTrailEvent;
import Interfaces.AuthenticateI;
import Qualifiers.LoginQ;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
@LoginQ(LoginQ.LoginChoice.Librarian)
public class LibrarianLoginBean implements AuthenticateI<Librarian> {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    private Event<AuditTrailEvent> event;
    public boolean login(Librarian librarian) {
        recordTrail(librarian);
        LibrarianLoginDAO librarianLoginDAO = new LibrarianLoginDAO(entityManager);
       return librarianLoginDAO.login(librarian);
    }

    private void recordTrail(Librarian librarian) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        auditTrail.setDate(new Date());
        auditTrail.setDetail("Login");
        auditTrail.setUserId(librarian.getEmail());
        auditTrail.setUserType("Librarian");
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
    }
}
