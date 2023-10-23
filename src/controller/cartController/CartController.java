package controller.cartController;

import model.entity.Cart;
import model.service.cart.CartService;
import model.service.cart.ICart;

import java.util.List;

public class CartController {
    ICart cartService=new CartService();
//    User userLogin=cartService.getUserLogin();
    public List<Cart> getListCart(){
        return cartService.findAll();
    }
   public void addToCart(Cart cartItem){
        cartService.save(cartItem);
   }
   public void delete(int idCartItem){
        cartService.deleteById(idCartItem);
   }
   public Cart findById(int id){
      return cartService.findById(id) ;
   }
//   public void updateCart(Cart cart){
//        cartService.updateCart(cart);
//   }
   public boolean editQuantity(int idPro,int quantity){
        return cartService.editQuantity(idPro,quantity);
   }

}
