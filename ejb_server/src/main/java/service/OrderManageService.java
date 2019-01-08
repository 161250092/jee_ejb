package service;

import model.Order;
import model.ProductItem;

import javax.ejb.Remote;
import java.util.ArrayList;
@Remote
public interface OrderManageService {
    public ArrayList<Order> getUserAllOrders(String account);


    /**
     *
     * @param account
     * @param productList
     * @return
     */
    public  double addOrder(String account, ArrayList<ProductItem> productList);


}
