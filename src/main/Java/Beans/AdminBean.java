package Beans;

import DAOs.AdminDAO;
import Entities.Admin;
import Entities.AuditTrail;
import Entities.Student;
import Events.AuditTrailEvent;
import Interfaces.AuthenticateI;
import Qualifiers.LoginQ;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@LoginQ(LoginQ.LoginChoice.Admin)
public class AdminBean implements AuthenticateI<Admin> {
    @Inject
    private Event<AuditTrailEvent> event;
    @PersistenceContext
    EntityManager entityManager;

    public boolean login(Admin admin) {
        recordTrail(admin);
        AdminDAO adminDAO = new AdminDAO(entityManager);
        return adminDAO.login(admin);
    }

    private void recordTrail(Admin admin) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        auditTrail.setDate(new Date());
        auditTrail.setDetail("Login");
        auditTrail.setUserId(admin.getEmail());
        auditTrail.setUserType("Admin");
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
    }
}
