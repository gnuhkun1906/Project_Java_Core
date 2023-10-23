package model.service.order;

import config.Config;
import dataURL.Path;

import model.entity.Cart;
import model.entity.Order;
import model.entity.Product;
import model.entity.User;
import model.service.User.UserServiceIPLM;
import model.service.cart.CartService;
import model.service.product.ProductService;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrder {
    User userLogin = new UserServiceIPLM().getCurrentUser();
    //    List<Cart> listCart=userLogin.getListCart();
    List<Order> listOrder = new Config<Order>().readFromFile(Path.PATH_ORDER);
    List<User> listUser;

    @Override
    public List<Order> findAll() {
        return listOrder;
    }

    @Override
    public void save(Order order) {
        listOrder.add(order);
        new Config<Order>().writeToFile(Path.PATH_ORDER, listOrder);
        listUser = new Config<User>().readFromFile(Path.PATH_USER);
        for (User u : listUser) {
            if (u.getId() == userLogin.getId()) {
                u.getListCart().clear();
            }
        }
        new Config<User>().writeToFile(Path.PATH_USER, listUser);
    }

    private Product checkQuantity(Cart cart) {
        List<Product> listPro = new ProductService().findAll();
        for (Product pro : listPro) {
            if (pro.getProductId() == cart.getProduct().getProductId()) {
                if (cart.getQuantity() > pro.getQuantity()) {
                    return cart.getProduct();
                }
            }
        }
        return null;
    }
//    private int checkQuantity(Cart cart){
//        List<Cart> listCart=;
//        List<Product> listPro = new ProductService().findAll();
//        for (Cart cart : order.getListCart() ){
//            if (cart.getProduct().getProductId() == ) {
//
//            }
//        }
//    }


    public List<Cart> checkNotMatchCart(List<Cart> listCart){
        List<Cart> notMatchStockCart = new ArrayList<>();

        for (Cart cart : listCart) {
            Product proTemp = checkQuantity(cart);
            if (proTemp != null) {
                notMatchStockCart.add(cart);
            }
        }
        return notMatchStockCart;
    }

    @Override
    public List<Cart> checkMatchCart(List<Cart> carts) {
        List<Cart> matchStockCart = new ArrayList<>();

        for (Cart cart : carts) {
            Product proTemp = checkQuantity(cart);
            if (proTemp == null) {
                matchStockCart.add(cart);
            }
        }
        return matchStockCart;
    }

    @Override
    public void minusPro(Order order) {
        List<Cart> cartList=new CartService().findAll();
        List<Cart> matchStockCart = new ArrayList<>();

        for (Cart cart : order.getListCart()) {
            Product proTemp = checkQuantity(cart);
            if (proTemp == null) {
                matchStockCart.add(cart);
            }
        }

        for (Cart cart : matchStockCart) {
            calculateMinusPro(cart);
        }

        for (Cart cart : matchStockCart) {
            order.getListCart().remove(cart);
        }
        new Config<Cart>().writeToFile(Path.PATH_CART,cartList);

    }
//    public void additionPro(Product pro){
//        List<Cart> listCart=new Order().getListCart();
//        List<Product> listPro=new ProductService().findAll();
//        for (:
//             ) {
//
//        }
//    }

    private void calculateMinusPro(Cart cart) {
        List<Product> listPro = new ProductService().findAll();
        for (Product pro : listPro) {
            if (pro.getProductId() == cart.getProduct().getProductId()) {
                pro.setQuantity(pro.getQuantity() - cart.getQuantity());
            }
        }

        new Config<Product>().writeToFile(Path.PATH_PRODUCT,listPro);
    }

    @Override
    public Order findById(int id) {
        for (Order order:listOrder) {
            if (order.getId()==id){
               return order;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (Order order : listOrder) {
            if (order.getId() == id) {
                listOrder.remove(order);
                new Config<Order>().writeToFile(Path.PATH_ORDER, listOrder);
                System.out.println("Delete Success !");
                break;
            } else {
                System.out.println("Delete Fail!!");
                break;
            }
        }
    }

    @Override
    public Order inputData() {
        return null;
    }
}
