package Servlets;

import Entities.Admin;
import Interfaces.AuthenticateI;
import Qualifiers.LoginQ;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "adminLogin")
public class AdminLogin extends  CustomServlet {
    @Inject
    @LoginQ(value = LoginQ.LoginChoice.Admin)
    private AuthenticateI<Admin> authenticateI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("adminLogin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
      Admin admin  = new Admin();
      admin.setEmail(get(req,"email"));
      admin.setPassword(get(req,"pass"));
      if(authenticateI.login(admin)){
          HttpSession session = req.getSession();
          session.setAttribute("AdminEmail", admin.getEmail());
          resp.sendRedirect("adminPage");
      } else {
          out.println("<html><body><p><a href=\"adminLogin.jsp\">  Try Again </a></p></body></html>");
          out.println("Incorrect password");
      }
    }
}
