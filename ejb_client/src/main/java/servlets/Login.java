package servlets;


import Util.JNDI;
import ejbFactory.EJBFactory;
import model.Product;
import model.ProductItem;
import service.LoginManageService;
import service.OnlineCountService;
import service.ProductManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Servlet implementation class servlets.Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoginManageService loginManageService = (LoginManageService) EJBFactory.getEJB(JNDI.getLoginServiceJNDI());

    private ProductManageService productManageService = (ProductManageService) EJBFactory.getEJB(JNDI.getProductServiceJNDI());

    private OnlineCountService onlineCountService = (OnlineCountService)EJBFactory.getEJB(JNDI.getOnlineCountService());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int state = -1;

        state = loginManageService.Login_in(request.getParameter("user"),request.getParameter("pw"));

        if(state == 0)
            showError(response);

        else if(state == 1) {
            request.getSession().setAttribute("account",request.getParameter("user"));
System.out.println("account已经修改为"+request.getSession().getAttribute("account"));

            List<Product> products = productManageService.getAllProductInfo();

            int onlineUser = onlineCountService.getUserNumber();

System.out.println("有商品:"+products.size());
System.out.println("在线用户:"+ onlineUser);

            request.getSession().setAttribute("online", onlineUser);
            request.getSession().setAttribute("visitor", onlineCountService.getVisitorNumber());
            request.getSession().setAttribute("all",onlineUser+ onlineCountService.getVisitorNumber());

            request.getSession().setAttribute("products",products);
            request.getSession().setAttribute("orderItemList",new ArrayList<ProductItem>());

            request.getRequestDispatcher("order/listProduct.jsp").forward(request, response);
        }
    }




    //
    private void showError(HttpServletResponse response) throws ServletException, IOException{

        PrintWriter out = response.getWriter();
        String title = "username or password error";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                 "</body></html>");
    }



}
