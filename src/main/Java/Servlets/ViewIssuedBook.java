package Servlets;

import Entities.Book;
import Entities.IssuedBook;
import Interfaces.BookI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "viewIssuedbooks")
public class ViewIssuedBook extends CustomServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out  = resp.getWriter();
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setReturnStatus("No");
      if(bookI.viewIssuedbooks(issuedBook)!=null) {
          List<IssuedBook> issueBooks = bookI.viewIssuedbooks(issuedBook);
          req.setAttribute("booklist",issueBooks);
          RequestDispatcher rd = req.getRequestDispatcher("viewIssuedBook.jsp");
          rd.forward(req,resp);
      }
      else {
          out.println("No books issued");
      }
    }
}
