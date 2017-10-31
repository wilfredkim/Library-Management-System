package Servlets;

import Entities.Book;
import Interfaces.BookI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "searchbook")
public class SearchBook  extends CustomServlet{
    @EJB
    BookI bookI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("searchBook.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
         Book book = new Book();
         book.setBook_number(get(req,"booknum"));
         if(bookI.searchBook(book)!=null){
             Book books = bookI.searchBook(book);
             bookArrayList.add(books);
             req.setAttribute("booklist",bookArrayList);
             /*req.setAttribute("number",books.getBook_number());
             req.setAttribute("name",books.getName());
             req.setAttribute("author",books.getAuthor());
             req.setAttribute("yop",books.getYearofPublications());
             req.setAttribute("category",books.getBookCategory());
             req.setAttribute("location",books.getBookLocation());*/

             RequestDispatcher rd  = req.getRequestDispatcher("displaySearchBook.jsp");
             rd.forward(req,resp);
         } else {
             out.println("<html><body><p><a href=\"searchBook.jsp\">  Try Again </a></p></body></html>");
             out.println("Book not found");
         }
    }
}
