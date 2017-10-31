package Servlets;

import Entities.Librarian;
import Interfaces.AuthenticateI;
import Interfaces.LibrarianI;
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

@WebServlet(urlPatterns = "librarianLogin")
public class LibrarianLogin  extends  CustomServlet{
    @Inject
    @LoginQ(value = LoginQ.LoginChoice.Librarian)
    private AuthenticateI<Librarian> authenticateI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("librarianLogin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Librarian librarian = new Librarian();
        librarian.setEmail((get(req, "email")));
        librarian.setPassword(getMd5(get(req, "pass")));
        if (authenticateI.login(librarian)) {

            HttpSession session = req.getSession();
            session.setAttribute("LibrarianEmail", get(req, "email"));
            resp.sendRedirect("librarianPage");
            //out.println("sucessfully");
        } else {

            out.println("<html><body><p><a href=\"librarianLogin.jsp\">  Try Again </a></p></body></html>");
            out.println("Incorrect password");
        }
    }

}
