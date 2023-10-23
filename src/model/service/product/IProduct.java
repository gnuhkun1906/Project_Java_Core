package model.service.product;

import model.entity.Product;
import model.service.IGenericService;

import java.util.List;

public interface IProduct extends IGenericService<Product> {
     List<Product> findByName(String name);

}
