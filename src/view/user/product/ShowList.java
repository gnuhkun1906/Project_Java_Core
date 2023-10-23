package view.user.product;

import config.Message;
import controller.product.ProductController;
import model.entity.Product;

import java.util.List;

public class ShowList {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getListProduct();

    public void showListProduct() {
        if (productList.size() == 0) {
            System.err.println(Message.PRODUCT_NOT_AVAILABLE);
        } else {
            System.out.println("------------------------------------------ LIST PRODUCT ------------------------------------------");
            for (Product listProduct : productList) {
                listProduct.setStatus(listProduct.getQuantity() > 0);
                System.out.println("ProductId: "+listProduct.getProductId()+"\t" +
                        "Product Name: "+listProduct.getProductName()+"\t" +
                        "Price: "+listProduct.getPrice()+"\t" +
                        "Status: "+(listProduct.isStatus() ? "Stocking" : "Sold Out")+"\t" +
                        "Quantity: "+listProduct.getQuantity() );
                System.out.println("--------------------------------------------------------------------------------------------------");

            }
        }

    }
}
