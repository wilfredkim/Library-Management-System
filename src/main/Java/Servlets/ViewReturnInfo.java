package Servlets;

import Entities.IssuedBook;
import Entities.ReturnInfo;
import Interfaces.ReturnInfoI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "viewReturnInfo")
public class ViewReturnInfo extends CustomServlet {
    @EJB
    ReturnInfoI returnInfoI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReturnInfo returnInfo = new ReturnInfo();
        HttpSession session =req.getSession(false);
        returnInfo.setIssuedBook((IssuedBook) session.getAttribute("issuedbook"));
        if(returnInfoI.viewreturnInfo(returnInfo)!=null){
            List<ReturnInfo>infoList = returnInfoI.viewreturnInfo(returnInfo);
            req.setAttribute("infolist",infoList);
            RequestDispatcher rd  = req.getRequestDispatcher("viewReturnInfo.jsp");
            rd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
