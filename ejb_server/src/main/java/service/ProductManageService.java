package service;

import model.Product;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface ProductManageService {
    public ArrayList<Product> getAllProductInfo();


    public int getProductRepertory(int productId);


    public boolean stockOut(int productId, int quantity);
}
