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

@WebServlet(urlPatterns = "deleteBook")
public class DeleteBook extends CustomServlet {
    @EJB
    BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("viewBookLibrarian.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Book book = new Book();
        book.setBook_number(get(req, "number"));
        if (bookI.deleteBook(book)) {
          resp.sendRedirect("viewAllBooks");
        }
        else {
            out.println("Could not delete book");
            out.println("<html><body><p><a href=\"viewBookLibrarian.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
