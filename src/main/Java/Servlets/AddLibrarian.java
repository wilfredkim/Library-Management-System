package Servlets;

import DAOs.LibrarianLoginDAO;
import Entities.Librarian;
import Interfaces.LibrarianI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addLibrarian")
public class AddLibrarian extends CustomServlet {
    @EJB
    LibrarianI librarianI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addLibrarian.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (get(req, "pass").equals(get(req, "cpass"))) {
            Librarian librarian = new Librarian();
            librarian.setPassword(getMd5(get(req, "pass")));
            librarian.setEmail((get(req, "email")));
            librarian.setWorkNumber(get(req, "worknum"));
            librarian.setName(get(req, "name"));
            if(librarianI.addLibrarian(librarian)){
                resp.sendRedirect("viewLibrarian");
            }else {
                out.println("could not add");
                out.println("<html><body><p><a href=\"addLibrarian.jsp\">  Try Again </a></p></body></html>");
            }
        } else {
            out.println("password doesnot match");
            out.println("<html><body><p><a href=\"addLibrarian.jsp\">  Try Again </a></p></body></html>");
        }

    }
}
