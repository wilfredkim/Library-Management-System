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
import java.util.List;
@WebServlet(urlPatterns = "viewLibrarian")
public class ViewLibrarian extends  CustomServlet {
    @EJB
    LibrarianI librarianI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(librarianI.viewLibrarian()!=null){
            List<Librarian> librarianList = librarianI.viewLibrarian();
            req.setAttribute("librarianlist",librarianList);
            RequestDispatcher rd  = req.getRequestDispatcher("viewLibrarian.jsp");
            rd.forward( req,resp);
        }
    }
}
