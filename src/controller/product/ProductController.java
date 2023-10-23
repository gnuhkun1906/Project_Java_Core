package controller.product;

import model.entity.Product;
import model.service.product.ProductService;

import java.util.List;

public class ProductController {
    ProductService productService=new ProductService();
    public List<Product> getListProduct(){
        return productService.findAll();
    }
    public void createPro(Product product){
        productService.save(product);
    }
    public void updatePro(Product product){
        productService.save(product);
    }
    public void deleteProById(int id){
            productService.deleteById(id);
    }
    public Product findById(int id){
        return productService.findById(id);
    }
    public List<Product> findByName(String name){
        return productService.findByName(name);
    }
    public Product inputData(){
        return productService.inputData();
    }
    public List<Product> searchPro(String name){
       return productService.findByName(name);
    }

}
