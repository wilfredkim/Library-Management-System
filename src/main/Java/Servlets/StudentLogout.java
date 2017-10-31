package Servlets;

import Entities.AuditTrail;
import Events.AuditTrailEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "studentLogout")
public class StudentLogout extends  CustomServlet {
    @Inject
    private Event<AuditTrailEvent> event;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = getHttpSession(req);
        session.invalidate();
        resp.sendRedirect("studentLogin");
    }

    private HttpSession getHttpSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        session.getAttribute("StudentEmail");
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        auditTrail.setDate(new Date());
        auditTrail.setDetail("Logout");
        auditTrail.setUserId((String) session.getAttribute("StudentEmail"));
        auditTrail.setUserType("Student");
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
        return session;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
