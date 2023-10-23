package model.service.cart;

import config.Config;
import config.Message;
import dataURL.Path;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import model.service.User.UserServiceIPLM;
import model.service.product.ProductService;

import java.util.List;

public class CartService implements ICart {
    User userLogin = new UserServiceIPLM().getCurrentUser();
    List<Product> listProduct = new ProductService().findAll();
    List<Cart> listCart;
    List<User> listUser;

    public CartService() {
        listUser = new Config<User>().readFromFile(Path.PATH_USER);
        for (User u : listUser
        ) {
            if (u.getId() == userLogin.getId()) {
                listCart = u.getListCart();
            }
        }
    }

    @Override
    public List<Cart> findAll() {
        return listCart;
    }

    @Override
    public void save(Cart cart) {
        boolean check = false;
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getProduct().getProductId() == cart.getProduct().getProductId()) {
                listCart.get(i).setQuantity(listCart.get(i).getQuantity() + cart.getQuantity());
                check = true;
                break;
            }
        }
        if (!check) {
            listCart.add(cart);
        }
        for (User u : listUser
        ) {
            if (u.getId() == userLogin.getId()) {
                u.setListCart(listCart);
            }
        }

        new Config<User>().writeToFile(Path.PATH_USER, listUser);
    }

    @Override
    public Cart findById(int id) {
        for (Cart cart : listCart) {
            if (cart.getProduct().getProductId() == id) {
                return cart;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        boolean check=false;
        for (Cart cart : listCart) {
            if (cart.getProduct().getProductId() == id) {
                listCart.remove(cart);
                new Config<User>().writeToFile(Path.PATH_USER, listUser);
                System.out.println(Message.DELETE_SUCCESS);
                check=true;
                break;
            }
        }
        if (!check){
            System.err.println(Message.FINDBYID_FAIL);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public Cart inputData() {
        return null;
    }


//    public boolean addToCart(Cart cartItem){
//        List<Cart> listCartItem=userLogin.getListCart();
//        if (listCartItem.size()==0){
//            listCartItem.add(cartItem);
//            save(cartItem);
//            return true;
//        }else {
//            for (Cart cart:listCartItem) {
//                if (cart.getProduct().getProductId()==cartItem.getProduct().getProductId()){
//                    cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
//                    save(cart);
//                    return true;
//                }
//            }
//            listCartItem.add(cartItem);
//            save(cartItem);
//            return true;
//        }
//    }

    @Override
    public boolean editQuantity(int idPro, int quantity) {
        for (Cart cartItem : listCart) {
            if (cartItem.getProduct().getProductId() == idPro) {
                if (quantity < 0) {
                    return false;
                } else {
                    cartItem.setQuantity(quantity);
                    new Config<User>().writeToFile(Path.PATH_USER, listUser);
                    new Config<Product>().writeToFile(Path.PATH_PRODUCT, listProduct);
                }
                System.out.println("====>>>Update Success");
            }
            System.err.println(Message.FINDBYID_FAIL);
        }
        return false;
    }
}
