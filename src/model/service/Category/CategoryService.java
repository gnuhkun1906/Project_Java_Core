package model.service.Category;

import config.Config;
import config.InputMethod;
import config.Message;
import dataURL.Path;
import model.entity.Category;


import java.util.List;

public class CategoryService implements ICategory {
    List<Category> listCategory = new Config<Category>().readFromFile(Path.PATH_CATEGORY);

    @Override
    public List<Category> findAll() {
        return listCategory;
    }

    @Override
    public void save(Category category) {
        if (findById(category.getCategoryId())==null){
            listCategory.add(category);
        }else {
        int index=listCategory.indexOf(findById(category.getCategoryId()));
        listCategory.set(index,category);
        }
        new Config<Category>().writeToFile(Path.PATH_CATEGORY,listCategory);
    }

    @Override
    public Category findById(int id) {
        for (Category category : listCategory
        ) {
            if (category.getCategoryId() == id) {
                return category;
            }
        }
        return null;
    }
    public Category findByName(String categoryName){
        for (Category category : listCategory
        ) {
            if (category.getCategoryName().equals(categoryName)) {
                return category;
            }
        }
        return  null;
    }

    @Override
    public void deleteById(int id) {
        boolean check=false;
        for (Category category:listCategory) {
            if (category.getCategoryId()==id){
                listCategory.remove(category);
                new Config<Category>().writeToFile(Path.PATH_CATEGORY,listCategory);
                System.out.println(Message.DELETE_SUCCESS);
                check=true;
                break;
            }
        }
        if (!check){
            System.err.println("Delete fail...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Category inputData() {
        int id=0;
        if (listCategory.size()==0){
            id=1;
        }else {
            id=listCategory.get(listCategory.size()-1).getCategoryId()+1;
        }
        System.out.print("Enter the name Category : ");
        String nameCategory= InputMethod.getString();
        Category newCategory= new Category(id,nameCategory);
        return newCategory;
    }
}
