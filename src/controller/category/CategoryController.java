package controller.category;

import model.entity.Category;
import model.service.Category.CategoryService;

import java.util.List;

public class CategoryController {
   CategoryService categoryService=new CategoryService();
   public List<Category> getListCategory(){
       return categoryService.findAll();
   }
   public void create(Category category){
        categoryService.save(category);
   }

   public void update(Category category){
       categoryService.save(category);
   }
   public Category findByName(String categoryName){
        return categoryService.findByName(categoryName);
   }
   public Category findById(int id){
       return categoryService.findById(id);
   }
   public void delete(int id){
       categoryService.deleteById(id);
   }
   public Category inputData(){
       return categoryService.inputData();
   }
}
