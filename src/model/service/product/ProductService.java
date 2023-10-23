package model.service.product;

import config.Config;
import config.InputMethod;
import config.Message;
import controller.category.CategoryController;
import dataURL.Path;
import model.entity.Category;
import model.entity.Product;
import model.service.Category.CategoryService;
import view.admin.category.ShowListCategory;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductService implements IProduct {
    List<Product> listProduct = new Config<Product>().readFromFile(Path.PATH_PRODUCT);

    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) == null) {
            listProduct.add(product);
        } else {
            int index = listProduct.indexOf(findById(product.getProductId()));
            listProduct.set(index, product);
        }
        new Config<Product>().writeToFile(Path.PATH_PRODUCT, listProduct);
    }

    @Override
    public Product findById(int id) {
        for (Product product : listProduct) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        boolean check=false;
        for (Product product : listProduct) {
            if (product.getProductId() == id) {
                listProduct.remove(product);
                System.out.println(Message.DELETE_SUCCESS);
                new Config<Product>().writeToFile(Path.PATH_PRODUCT, listProduct);
                check=true;
                break;
            }
        }
        if (!check){
            System.err.println(Message.FINDBYID_FAIL);
        }
    }


    @Override
    public Product inputData() {
        Product newProduct = new Product();
        if (listProduct.size() == 0) {
            newProduct.setProductId(1);
        } else {
            newProduct.setProductId(listProduct.get(listProduct.size() - 1).getProductId() + 1);
        }
        List<Category> listCategory = new CategoryService().findAll();
//        for (Category category : listCategory) {
//            System.out.println(category);
//        }
        new ShowListCategory();
        Category categoryInitial = null;
        System.out.print("Select the Category : ");
        int category = InputMethod.getInteger();
        for (Category cate : listCategory) {
            if (cate.getCategoryId() == category) {
                categoryInitial = cate;
                newProduct.setCategory(categoryInitial);
                break;
            }
        }
        System.out.print("Enter the ProductName : ");
        newProduct.setProductName(InputMethod.getString());
        System.out.print("Enter the Price : ");

//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//
//        price=currencyVN.format(price);
        newProduct.setPrice(InputMethod.getFloat());
        System.out.print("Enter the quantity : ");
        newProduct.setQuantity(InputMethod.getInteger());
        newProduct.setStatus(true);
        return newProduct;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> search = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getProductName().contains(name)) {
                search.add(product);
//                System.out.println(search);

            }
        }
        return search;
    }


}
