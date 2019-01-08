package model;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Order implements Serializable{
    int orderId;
    String account;
    Date orderTime;
    ArrayList<ProductItem>  list;
    double total;

    public Order(int orderId, String account,Date orderTime, ArrayList<ProductItem> list, double total) {
        this.orderId = orderId;
        this.account = account;
        this.orderTime = orderTime;
        this.list = list;
        this.total = total;
    }


    public int getOrderId() {
        return orderId;
    }

    public String getAccount() {
        return account;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public ArrayList<ProductItem> getList() {
        return list;
    }

    public double getTotal() {
        return total;
    }

    public Order(int orderId, String account, Date orderTime) {
        this.orderId = orderId;

        this.account = account;
        this.orderTime = orderTime;
        list = null;
        total = 0;
    }

}
