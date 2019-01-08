package service.bean;

import Factory.DaoFactory;
import dao.ProductDao;
import model.Product;
import service.ProductManageService;

import javax.ejb.Stateless;
import java.util.ArrayList;
@Stateless
public class ProductManageServiceBean implements ProductManageService {
    private ProductDao productDao = DaoFactory.getProductDao();

    public ArrayList<Product> getAllProductInfo() {
        return productDao.getAllProductInfo();
    }

    public int getProductRepertory(int productId) {
        return productDao.getProductRepertory(productId);
    }

    public boolean stockOut(int productId, int quantity) {
        return productDao.stockOut(productId,quantity);
    }

}
