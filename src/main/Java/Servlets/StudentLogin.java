package Servlets;

import Entities.Librarian;
import Entities.Student;
import Interfaces.AuthenticateI;
import Interfaces.StudentI;
import Qualifiers.LoginQ;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "studentLogin")
public class StudentLogin extends  CustomServlet {
    @Inject
    @LoginQ(value = LoginQ.LoginChoice.Student)
    private AuthenticateI<Student> authenticateI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("studentLogin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Student student = new Student();
        student.setPassword(getMd5(get(req,"pass")));
        student.setEmail((get(req,"email")));
        if (authenticateI.login(student)) {
            HttpSession session = req.getSession();
            session.setAttribute("StudentEmail", get(req, "email"));
            resp.sendRedirect("StudentPage");
        } else {
            out.println("<html><body><p><a href=\"studentLogin.jsp\">  Try Again </a></p></body></html>");
            out.println("Incorrect password");
        }

    }
}
