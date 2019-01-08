package service.bean;

import Factory.DaoFactory;
import dao.OrderDao;
import model.Order;
import model.ProductItem;
import service.OrderManageService;

import javax.ejb.Stateless;
import java.util.ArrayList;
@Stateless
public class OrderManageServiceBean implements OrderManageService {
    private OrderDao orderDao = DaoFactory.getOrderDao();

    public ArrayList<Order> getUserAllOrders(String account) {
        return orderDao.getUserAllOrders(account);
    }

    public double addOrder(String account, ArrayList<ProductItem> productList) {
        return orderDao.addOrder(account,productList);
    }
}
