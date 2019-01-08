package model;

import java.io.Serializable;

public class Product implements Serializable{
    int productId;
    String productName;
    double price;
    int repertory;

    public Product(int productId, String productName, double price, int repertory) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.repertory = repertory;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getRepertory() {
        return repertory;
    }
}
