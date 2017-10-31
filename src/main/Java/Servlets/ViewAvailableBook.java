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

@WebServlet(urlPatterns = "viewAvailableBooks")
public class ViewAvailableBook extends CustomServlet {
    @EJB
    BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Book book = new Book();
        book.setStatus("Not-Issued");
        if (bookI.viewAvailablebooks(book) != null) {
            List<Book>bookList = bookI.viewAvailablebooks(book);
            req.setAttribute("booklist",bookList);
            RequestDispatcher rd = req.getRequestDispatcher("viewAvailableBook.jsp");
            rd.forward(req,resp);
        } else {
            out.println("No books available");
        }
    }
}
