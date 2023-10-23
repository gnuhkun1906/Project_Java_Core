package view.admin.prodct;

import config.InputMethod;
import config.Message;
import controller.category.CategoryController;
import controller.product.ProductController;
import model.entity.Category;
import model.entity.Product;

import java.sql.SQLOutput;
import java.util.List;

public class UpdateProduct {
    ProductController productController=new ProductController();
    public UpdateProduct() {
        System.out.println("----------------- FORM UPDATE -----------------");
        System.out.print("Enter the id want to update : ");
        int idUpdate= InputMethod.getInteger();
        if (productController.findById(idUpdate)==null){
            System.err.println(Message.FINDBYID_FAIL);
        }else {
            System.out.print("Enter the ProductName change : ");
            String proName=InputMethod.getString();
            List<Category> listCategory=new CategoryController().getListCategory();
            Category categoryInitial=null;
            for (Category category :listCategory) {
                System.out.println(category);
            }
            System.out.print("Select Id want to change : ");
            int idUpDate=InputMethod.getInteger();
            for (Category cate:listCategory) {
                if (cate.getCategoryId()==idUpDate){
                    categoryInitial=cate;
                }
            }
            System.out.print("Enter the price change : ");
            float price=InputMethod.getFloat();
            System.out.print("Enter the quantity change : ");
            int quantity=InputMethod.getInteger();
            Product newProduct=new Product(idUpDate,proName,price,quantity,categoryInitial);
            productController.updatePro(newProduct);
            System.out.println("-----------------------------------------------");

        }

    }
}
