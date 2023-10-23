package model.entity;

import java.io.Serializable;

public class Cart implements Serializable {
    private static final long serialVersionUID = -2271569601741066889L;
    private int id;
    private Product product;
    private int quantity;

    public Cart() {
    }

    public Cart(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                "ProductId : " +this.product.getProductId() + "\t\t"
                        + "Product Name : " + this.product.getProductName() + "\t\t"
                        + "Price : " + this.product.getPrice() + "\t\t"
                        + "Quantity : " + this.quantity +"\n";
    }
}
