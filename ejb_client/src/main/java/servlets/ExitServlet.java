package servlets;

import Util.JNDI;
import ejbFactory.EJBFactory;
import service.LoginManageService;
import service.OnlineCountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ExitServlet")
public class ExitServlet  extends HttpServlet {
    LoginManageService loginManageService = (LoginManageService) EJBFactory.getEJB(JNDI.getLoginServiceJNDI());
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginManageService.exit( (String)req.getSession().getAttribute("account"));
        req.getSession().removeAttribute("account");//从session中移除对象
        resp.sendRedirect("user/login.jsp");

    }

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



}
