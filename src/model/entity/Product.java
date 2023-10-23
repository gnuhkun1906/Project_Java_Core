package model.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 7979035219769641084L;
    private int productId;
    private String productName;
    private float price;
    private int quantity;
    private Category category;
    private boolean status;


    public Product() {
    }

    public Product(int productId, String productName, float price, int quantity, Category category, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.status = status;
    }

    public Product(int productId, String productName, float price, int quantity, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        this.setStatus(quantity > 0);

        return "ProductId : " + productId + "\n"
                + "Product Name : " + productName + "\n"
                + "Price : " + price + "\n"
                + "Status : " +( status ? "Stocking":"Sold Out")+ "\n";
    }

}
