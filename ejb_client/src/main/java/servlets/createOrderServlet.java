package servlets;


import Util.JNDI;
import ejbFactory.EJBFactory;
import model.ProductItem;
import service.LoginManageService;
import service.OrderManageService;
import service.ProductManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/createOrderServlet")
public class createOrderServlet extends HttpServlet {


    private OrderManageService orderManageService = (OrderManageService) EJBFactory.getEJB(JNDI.getOrderServiceJNDI());

    private LoginManageService loginManageService=(LoginManageService) EJBFactory.getEJB(JNDI.getLoginServiceJNDI());


    private ProductManageService productManageService = (ProductManageService) EJBFactory.getEJB(JNDI.getProductServiceJNDI());
    ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的user
        String user = "";
         user=(String)req.getSession().getAttribute("account");
        //判断，如果user==null，则尚未登录，直接跳转到登录界面
        if(user.equals(""))
        {
            resp.sendRedirect("/servlets.Login");
            //返回
            return;
        }
        ArrayList<ProductItem>  productList = (ArrayList<ProductItem>)(req.getSession().getAttribute("orderItemList"));

        if(!ableToPlaceOrder(productList))
        {
            String message="库存不足，订单提交失败";
            System.out.println(message);
            req.setAttribute("message",message);
            req.getRequestDispatcher("order/orderFailMessage.jsp").forward(req,resp);
            return;
        }

//添加订单
        double total =orderManageService.addOrder(user,productList);

        //折扣策略
        String discount="";
        if(total>=200) {
            total *= 0.9;
            discount="已经折扣至"+total+"元";
        }
//扣除账户余额
        loginManageService.deductFare(user,total);
//出库

        for(ProductItem item:productList)
            productManageService.stockOut(item.getProductId(),item.getQuantity());

        productList.clear();


System.out.println("购物车清空:"+productList.size());

        String message=discount+"    订单提交成功!已经为您跳转到商品列表页！";
        req.setAttribute("message",message);
        req.getRequestDispatcher("order/listProduct.jsp").forward(req,resp);

    }

    public boolean  ableToPlaceOrder( ArrayList<ProductItem>  productList){
        for(ProductItem item:productList)
            if(item.isOos())
                return false;
        return true;
    }



}
