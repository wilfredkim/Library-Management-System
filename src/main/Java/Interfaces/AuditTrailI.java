package Interfaces;

import Entities.AuditTrail;

import javax.ejb.Local;

@Local
public interface AuditTrailI {
    boolean recordTrail(AuditTrail auditTrail);
}
