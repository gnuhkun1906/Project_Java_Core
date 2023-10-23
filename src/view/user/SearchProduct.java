package view.user;

import config.InputMethod;
import controller.product.ProductController;

public class SearchProduct {
    ProductController productController=new ProductController();

    public SearchProduct() {
        System.out.print("Enter the Product name want to search : ");
        String searchName= InputMethod.getString();
        productController.findByName(searchName);
    }
}
