package Events;

import Entities.AuditTrail;

public class AuditTrailEvent {
    AuditTrail auditTrail;

    public AuditTrail getAuditTrail() {
        return auditTrail;
    }

    public void setAuditTrail(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
}
