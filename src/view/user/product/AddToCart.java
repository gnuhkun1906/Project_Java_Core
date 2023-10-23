package view.user.product;

import config.InputMethod;
import config.Message;
import controller.cartController.CartController;
import controller.product.ProductController;
import controller.user.UserController;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;

import java.util.List;

public class AddToCart {
    CartController cartController = new CartController();
    List<Cart> listCart = cartController.getListCart();
    UserController userController = new UserController();


    Cart cartItem = new Cart();

    public void addToCart() {
        new ShowList().showListProduct();
        System.out.println("-------------- FORM --------------");
        if (listCart.size() == 0) {
            cartItem.setId(1);
        } else {
            cartItem.setId(listCart.get(listCart.size() - 1).getId() + 1);
        }
        System.out.print("Enter the Id Product : ");
        Product product = new ProductController().findById(InputMethod.getInteger());
        if (product == null) {
            System.err.println(Message.FINDBYID_FAIL);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enter the any key to continue.....");
            InputMethod.pressAnyKey();
            new SelectionProduct();
//            addToCart();
        } else {
            System.out.print("Enter the Quantity : ");
            int quantity = InputMethod.getInteger();

            cartItem.setQuantity(quantity);
            cartItem.setProduct(product);
            cartController.addToCart(cartItem);
            System.out.println("----------------------------------");
            System.out.println(Message.ADD_SUCCESS);
        }
    }
}
