package Beans;

import DAOs.AuditTrailDAO;
import Entities.AuditTrail;
import Interfaces.AuditTrailI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@Local
public class AuditTrailBean  implements AuditTrailI{
    @PersistenceContext
    EntityManager entityManager;
    public boolean recordTrail(AuditTrail auditTrail) {

        AuditTrailDAO auditTrailDAO = new AuditTrailDAO(entityManager);
        return  auditTrailDAO.recordTrail(auditTrail);
    }
}
