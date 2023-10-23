package view.admin.prodct;

import config.Message;
import controller.product.ProductController;
import model.entity.Product;

public class CreateProduct {
    ProductController productController=new ProductController();
    public CreateProduct() {
        System.out.println("--------------- FORM CREATE PRODUCT --------------");
        Product newProduct=productController.inputData();
        productController.createPro(newProduct);
        System.out.println("--------------------------------------------------");
        System.out.println(Message.CREATE_SUCCESS);
    }
}
