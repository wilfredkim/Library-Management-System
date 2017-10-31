package Servlets;

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

@WebServlet(urlPatterns = "deleteLibrarian")
public class DeleteLibrarian extends  CustomServlet {
    @EJB
    LibrarianI librarianI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("viewLibrarian.jsp");
        rd.forward( req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Librarian librarian  = new Librarian();
        librarian.setWorkNumber(get(req,"number"));
        if(librarianI.deleteLibrarian(librarian)){
            resp.sendRedirect("viewLibrarian");
        }else {
            out.println("Could not delete ");
            out.println("<html><body><p><a href=\"viewLibrarian.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
