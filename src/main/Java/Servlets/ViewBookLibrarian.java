package Servlets;

import Entities.Book;
import Interfaces.BookI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(urlPatterns = "viewAllBooks")
public class ViewBookLibrarian extends  CustomServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out  = resp.getWriter();
        if(bookI.viewAllbooks()!=null){

            List<Book> bookList = bookI.viewAllbooks();
            req.setAttribute("bookslist",bookList);
            RequestDispatcher rd = req.getRequestDispatcher("viewBookLibrarian.jsp");
            rd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
