package Servlets;

import Entities.Book;
import Entities.IssuedBook;
import Entities.ReturnInfo;
import Entities.Student;
import Interfaces.BookI;
import Interfaces.ReturnInfoI;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "returnBook")
public class ReturnBook extends CustomServlet {
    @EJB
    BookI bookI;
    @EJB
    StudentI studentI;
    @EJB
    ReturnInfoI returnInfoI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("returnBook.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Book book = new Book();
        book.setBook_number(get(req, "booknum"));
        Book book1 = bookI.searchBook(book);
        Student student = new Student();
        student.setRegNo(get(req, "regno"));
        Student student1 = studentI.searchStudent(student);
        IssuedBook issuedBook1 = bookI.searchIssuedBook(get(req, "booknum"),get(req, "regno") );
        if (student1 != null && book1 != null && issuedBook1!= null) {
            if (book1.getStatus().equals("Not-Issued")) {
                out.println("book has been return");
                out.println("<html><body><p><a href=\"returnBook.jsp\">  Try Again </a></p></body></html>");
            } else {
                recordinfo(issuedBook1);
                book1.setStatus("Not-Issued");
                issuedBook1.setReturnStatus("Yes");
                if (bookI.returnBook(book1,issuedBook1)) {
                    out.println("Return successfully");
                    HttpSession session = req.getSession(false);
                    session.setAttribute("issuedbook",issuedBook1);
                    out.println("<html><body><p><a href=\"viewReturnInfo\"> View Return Information </a></p></body></html>");
                } else {
                    out.println(" could not return");
                    out.println("<html><body><p><a href=\"returnBook.jsp\">  Try Again </a></p></body></html>");
                }
            }
        } else {
            out.println(" not found student or book");
            out.println("<html><body><p><a href=\"returnBook.jsp\">  Try Again </a></p></body></html>");
        }
    }

    private void recordinfo(IssuedBook issuedBook1) {

        ReturnInfo returnInfo= new ReturnInfo();
        returnInfo.setIssuedBook(issuedBook1);
        returnInfo.setDate( new Date());
        float latefee=0;
        //in milliseconds
        long diff = new Date().getTime() - issuedBook1.getDatetoreturn().getTime();
        if(diff<0){
            latefee=0;
        }
        else {
            int late = (int) (diff / (24 * 60 * 60 * 1000));
            latefee= late * 10;
            returnInfo.setPenalty(latefee);
            returnInfo.setLate_days(late);

        }
        returnInfoI.recordInfo(returnInfo);
    }
}
