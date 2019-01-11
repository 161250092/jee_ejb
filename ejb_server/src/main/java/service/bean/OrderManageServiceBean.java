package service.bean;

import Factory.DaoFactory;
import dao.LoginDao;
import dao.OrderDao;
import model.Order;
import model.ProductItem;
import service.OrderManageService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
@Stateless
public class OrderManageServiceBean implements OrderManageService {

    @EJB
    OrderDao orderDao;
    public ArrayList<Order> getUserAllOrders(String account) {
        return orderDao.getUserAllOrders(account);
    }

    public double addOrder(String account, ArrayList<ProductItem> productList) {
        return orderDao.addOrder(account,productList);
    }
}
