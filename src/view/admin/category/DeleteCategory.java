package view.admin.category;

import config.InputMethod;
import config.Message;
import controller.category.CategoryController;

public class DeleteCategory {
    CategoryController categoryController=new CategoryController();
    public DeleteCategory() {
        new ShowListCategory();
        System.out.print("Enter the id want to delete : ");
        int id= InputMethod.getInteger();
            categoryController.delete(id);

    }
}
