package view.admin.category;


import config.Message;
import controller.category.CategoryController;
import model.entity.Category;


public class CreateCategory {
    CategoryController categoryController=new CategoryController();
    public  CreateCategory() {
            System.out.println("--------------FORM CATEGORY --------------");
           Category newCategory= categoryController.inputData();
            categoryController.create(newCategory);
            System.out.println(Message.CREATE_SUCCESS);
            System.out.println("----------END FORM CATEGORY --------------");
    }
}
