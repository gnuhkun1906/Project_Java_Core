package view.admin.prodct;

import config.InputMethod;
import controller.product.ProductController;

public class DeleteProduct {
    ProductController productController=new ProductController();

    public DeleteProduct() {
        System.out.println("----------- DELETE PRODUCT -------------");
        new ShowListProduct();
        System.out.print("Enter the Id want to Delete : ");
        int idDel= InputMethod.getInteger();
        productController.deleteProById(idDel);
        System.out.println("----------------------------------------");


    }
}
