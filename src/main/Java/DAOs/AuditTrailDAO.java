package DAOs;

import Entities.AuditTrail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class AuditTrailDAO extends CustomDAO<AuditTrail> {


    public AuditTrailDAO(EntityManager entityManager) {
        super(entityManager);
    }
    public boolean recordTrail(AuditTrail auditTrail) {
        return  this.addCustom(auditTrail);

    }
}
