package view.admin.prodct;

import config.InputMethod;
import controller.product.ProductController;
import model.entity.Product;

import java.util.List;

public class SearchProductByName {
    public SearchProductByName() {
        System.out.println("-------------------- SEARCH --------------------");
        System.out.print("Enter the Name Product want to search : ");
        String search= InputMethod.getString();
        List<Product> list= new ProductController().findByName(search);
        for (Product p:list) {
            System.out.println(p);
        }
//        System.out.println(list);
        System.out.println("------------------------------------------------");

    }
}
