package dao.impl;

import dao.DaoHelper;
import dao.ProductDao;
import model.Product;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Stateless
public class ProductDaoImpl implements ProductDao {

//    private static ProductDaoImpl productOrder = new ProductDaoImpl();
////
////    public static ProductDaoImpl getInstance(){return productOrder;}

    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
    @Override
    public ArrayList<Product> getAllProductInfo(){

System.out.println("invoke getAllProduct");
        ArrayList<Product> res = new ArrayList<Product>();
        Product p = null;
        String sql = "select * from product";

        try {
            Connection conn = daoHelper.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                p = new Product(rs.getInt("productId"),rs.getString("productName"),rs.getDouble("price"),rs.getInt("repertory"));
                res.add(p);
            }
System.out.println(res.size());
            psmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public int getProductRepertory(int productId) {
        return 0;
    }

    @Override
    public boolean stockOut(int productId, int quantity) {

        String sql = "update product set repertory=repertory-? where productId=?";

        Connection conn = null;
        try {
            conn = daoHelper.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,quantity);
            psmt.setInt(2,productId);
            psmt.executeUpdate();
            psmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}
