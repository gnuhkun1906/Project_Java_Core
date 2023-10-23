package view.user.cart;

import config.InputMethod;
import controller.cartController.CartController;
import controller.product.ProductController;
import model.entity.Cart;
import model.entity.Product;

public class DeleteProduct {
    CartController cartController=new CartController();
    public DeleteProduct() {
        System.out.print("Enter the Id Product want to delete : ");
        int idDel= InputMethod.getInteger();
        Cart cart=cartController.findById(idDel);

        cartController.delete(idDel);
//        cartController.updateCart(cart);
//        Product product=new ProductController().findById(idDel);
//        product.setQuantity(product.getQuantity()+cart.getQuantity());
//        new ProductController().updatePro(product);
    }
}
