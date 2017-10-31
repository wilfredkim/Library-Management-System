package Observers;

import Entities.AuditTrail;
import Events.AuditTrailEvent;
import Interfaces.AuditTrailI;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;

public class AuditTrailObserver {
    @EJB
    AuditTrailI auditTrailI;
    public  void observerTrail(@Observes AuditTrailEvent auditTrailEvent){
        auditTrailI.recordTrail(auditTrailEvent.getAuditTrail());

    }
}
