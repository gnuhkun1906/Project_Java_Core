package view.admin.category;

import config.InputMethod;
import config.Message;
import controller.category.CategoryController;
import model.entity.Category;

public class UpdateCategory {
    CategoryController categoryController=new CategoryController();
    public UpdateCategory() {
        System.out.println("---------- FORM UPDATE ----------");
        new ShowListCategory();
        System.out.print("Enter the id Update : ");
        int idUpdate= InputMethod.getInteger();
        if (categoryController.findById(idUpdate)==null){
            System.err.println(Message.FINDBYID_FAIL);
        }else {
            System.out.print("Enter the nameCategory change : ");
            String nameUpdate=InputMethod.getString();
            Category categoryUpdate=new Category(idUpdate,nameUpdate);
            categoryController.update(categoryUpdate);
            System.out.println(Message.UPDATE_SUCCESS);
        }
        System.out.println("-------- END FORM UPDATE --------");
    }
}
