package view.admin.prodct;

import config.InputMethod;
import config.Message;
import controller.product.ProductController;
import model.entity.Product;

import java.util.List;

public class ShowListProduct {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getListProduct();

    public ShowListProduct() {
        if (productList.size() == 0) {
            System.err.println(Message.PRODUCT_NOT_AVAILABLE);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enter the any key to continue....");
            InputMethod.pressAnyKey();
        } else {
            System.out.println("--------------------------------- LIST PRODUCT ---------------------------------");
            for (Product listProduct : productList) {
//                listProduct.setStatus(listProduct.getQuantity() > 0);
                System.out.printf("ProductId: %d\t", listProduct.getProductId());
                System.out.printf("Product Name: %s\t\t", listProduct.getProductName());
                System.out.printf("Price: %.2f\t", listProduct.getPrice());
//                System.out.printf("Status : %s\n", listProduct.isStatus() ? "Stocking" : "Sold Out");
                System.out.printf("Quantity: %d", listProduct.getQuantity());
                System.out.println();
                System.out.println("----------------------------------------------------------------------------");
            }
        }
    }
}
