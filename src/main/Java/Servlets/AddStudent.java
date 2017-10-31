package Servlets;

import Entities.Student;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

@WebServlet(urlPatterns = "addStudent")
public class AddStudent extends  CustomServlet {
    @EJB
    StudentI studentI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("addStudent.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
       Student student = new Student();
       if(get(req,"pass").equals(get(req,"cpass"))) {
           student.setName(get(req, "name"));
           student.setEmail((get(req, "email")));
           student.setYear(get(req, "yos"));
           student.setRegNo(get(req, "regno"));
           student.setPassword(getMd5(get(req,"pass")));
           if(studentI.register(student)){
               out.println("Added successfull");
               out.println("<html><body><p><a href=\"librarianPage\">  Home </a></p></body></html>");
           }else {
               out.println("could not add");
               out.println("<html><body><p><a href=\"addStudent.jsp\">  Try Again </a></p></body></html>");
           }
       }
       else {
           out.println("password does not match");
           out.println("<html><body><p><a href=\"addStudent.jsp\">  Try Again </a></p></body></html>");
       }
    }

}
