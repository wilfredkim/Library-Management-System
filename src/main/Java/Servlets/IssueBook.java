package Servlets;

import Entities.Book;
import Entities.IssuedBook;
import Entities.Student;
import Interfaces.BookI;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


@WebServlet(urlPatterns = "issueBook")
public class IssueBook extends CustomServlet {
    @EJB
    BookI bookI;
    @EJB
    StudentI studentI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("issueBook.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        IssuedBook issuedBook = new IssuedBook();
        Book book = new Book();
        book.setBook_number(get(req, "booknum"));
        Book book1 = bookI.searchBook(book);
         Student student = new Student();
            student.setRegNo(get(req, "regno"));
            Student student1 = studentI.searchStudent(student);
            if (student1 != null && book1 != null) {
                if (book1.getStatus().equals("Issued")) {
                    out.println("book has already been issued");
                    out.println("<html><body><p><a href=\"issueBook.jsp\">  Try Again </a></p></body></html>");
                } else {
                    book1.setStatus("Issued");
                    issuedBook.setStudent(student1);
                    issuedBook.setBook(book1);
                    issuedBook.setDateofIssue(Date.valueOf(get(req, "issuedate")));
                    issuedBook.setDatetoreturn(Date.valueOf(get(req, "returndate")));
                    issuedBook.setReturnStatus("No");

                    if (bookI.issueBook(book1, issuedBook)) {
                        out.println("Issued Successfully");
                        out.println("<html><body><p><a href=\"librarianPage\">  Home </a></p></body></html>");
                    } else {
                        out.println("Could not issue");
                        out.println("<html><body><p><a href=\"issueBook.jsp\">  Try Again </a></p></body></html>");
                    }
                }
            }else {
                out.println(" not found student or book");
                out.println("<html><body><p><a href=\"issueBook.jsp\">  Try Again </a></p></body></html>");
            }
        }


}
