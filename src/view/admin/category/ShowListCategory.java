package view.admin.category;

import config.Message;
import controller.category.CategoryController;
import model.entity.Category;

import java.util.List;

public class ShowListCategory {
    CategoryController categoryController = new CategoryController();

    public ShowListCategory() {
        System.out.println("-------------- LIST CATEGORY --------------");
        List<Category> listCategory = categoryController.getListCategory();
        for (Category category : listCategory) {
            if (listCategory.size() == 0) {
                System.err.println(Message.CATEGORY_NOT_AVAILABLE);
            } else {

                System.out.println("CategoryId: "+category.getCategoryId()+"\t\t" +
                        "CategoryName: "+category.getCategoryName());
                System.out.println("-------------------------------------------");
            }
        }
    }
}
