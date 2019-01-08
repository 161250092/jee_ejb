package model;

import java.io.Serializable;

public class ProductItem implements Serializable{
    int orderId;
    int productId;
    String productName;
    int quantity;
    double price;
    double totalPrice;
    boolean  oos;

    public ProductItem(int orderId, int productId, int quantity, double totalPrice,boolean oos) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.oos = oos;
    }

    public ProductItem(int productId, String productName, int quantity, double price, double totalPrice, boolean oos) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.oos = oos;
    }

    public ProductItem(int orderId, int productId, String productName, int quantity, double price, double totalPrice, boolean oos) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.oos = oos;
    }

    public ProductItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOos() {

        return oos;
    }

}
