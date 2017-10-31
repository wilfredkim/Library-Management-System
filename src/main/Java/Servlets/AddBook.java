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
import java.sql.Date;

@WebServlet(urlPatterns = "addbook")
public class AddBook extends CustomServlet {
    @EJB
    BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addBook.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Book book = new Book();
        book.setName(get(req, "name"));
        book.setAuthor(get(req, "author"));
        book.setIsbNo(get(req, "isb"));
        book.setBook_number(get(req, "booknum"));
        book.setBookCategory(get(req, "category"));
        book.setYearofPublications(Date.valueOf(get(req, "yop")));
        book.setBookLocation(get(req,"location"));
        book.setStatus("Not-Issued");
        if (bookI.addBook(book)) {
            out.println("Added successfully");
            resp.sendRedirect("viewAllBooks");
        } else {
            out.println("Could not add");
            out.println("<html><body><p><a href=\"addBook.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
