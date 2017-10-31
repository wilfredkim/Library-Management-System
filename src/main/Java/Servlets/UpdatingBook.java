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

@WebServlet(urlPatterns = "updatingBook")
public class UpdatingBook extends CustomServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         RequestDispatcher rd  = req.getRequestDispatcher("updateBook.jsp");
            rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Book book  = new Book();
        book.setBook_number(get(req,"number"));
        Book book1 = bookI.searchBook(book);
        if(book1!=null) {
            //book1.setBook_number(get(req,"number"));
            book1.setName(get(req, "name"));
            book1.setAuthor(get(req, "author"));
            book1.setYearofPublications(Date.valueOf(get(req, "yop")));
            book1.setBookCategory(get(req, "category"));
            book1.setBookLocation(get(req, "location"));
            book1.setIsbNo(get(req, "isb"));
            book1.setStatus(get(req, "status"));
            if (bookI.updateBook(book1)) {
                out.println("Updated successfully");
                resp.sendRedirect("viewAllBooks");
            } else {
                out.println("Could not update");
                out.println("<html><body><p><a href=\"updateBook\">  Try Again </a></p></body></html>");
            }
        } else {
            out.println("no book with that number in our records");
            out.println("<html><body><p><a href=\"updateBook\">  Try Again </a></p></body></html>");
        }
    }

}
