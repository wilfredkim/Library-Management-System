package Beans;

import DAOs.StudentLoginDAO;
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
@LoginQ(LoginQ.LoginChoice.Student)
public class StudentLoginBean implements AuthenticateI<Student> {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    private Event<AuditTrailEvent> event;
    public boolean login(Student student) {
        recordTrail(student);
        StudentLoginDAO studentLoginDAO = new StudentLoginDAO(entityManager);
         return studentLoginDAO.login(student);
    }
    private void recordTrail(Student student) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        auditTrail.setDate(new Date());
        auditTrail.setDetail("Login");
        auditTrail.setUserId(student.getEmail());
        auditTrail.setUserType("Student");
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
    }
}
