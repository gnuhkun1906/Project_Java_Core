package model.service.Category;

import model.entity.Category;
import model.service.IGenericService;

public interface ICategory extends IGenericService<Category> {
        Category findByName(String name);
}
