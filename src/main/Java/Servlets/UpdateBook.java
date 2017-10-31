package Servlets;

import Entities.Book;
import Interfaces.BookI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "updateBook")
public class UpdateBook extends CustomServlet {
    @EJB
    BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("viewBookLibrarian.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        Book book = new Book();
        book.setBook_number(get(req,"number"));
        if (bookI.searchBook(book) != null) {
            Book books = bookI.searchBook(book);
            bookArrayList.add(books);
            for(Book  book1:bookArrayList){
                HttpSession session  = req.getSession(false);
                session.setAttribute("name", book1.getName());
                session.setAttribute("number", book1.getBook_number());
                session.setAttribute("author",book1.getAuthor());
                session.setAttribute("yop",book1.getYearofPublications());
                session.setAttribute("category",book1.getBookCategory());
                session.setAttribute("location", book1.getBookLocation());
                session.setAttribute("status", book1.getStatus());
                session.setAttribute("isb", book1.getIsbNo());

                resp.sendRedirect("updatingBook");
            }

          /*  RequestDispatcher rd  = req.getRequestDispatcher("updateBook.jsp");
            rd.forward(req,resp);*/
        }
    }
}
