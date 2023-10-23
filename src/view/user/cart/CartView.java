package view.user.cart;

import config.InputMethod;
import config.Message;
import controller.cartController.CartController;
import controller.user.UserController;
import model.entity.Cart;
import view.user.HomeUser;
import view.user.product.AddToCart;
import view.user.product.ShowList;

import java.util.List;

public class CartView {
    CartController cartController = new CartController();
    List<Cart> listCartItem = cartController.getListCart();

    public void showListCart() {
        if (listCartItem.size()==0){
            try {
            System.err.println(Message.EMPTY_CART);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enter the any key to continue....");
            InputMethod.pressAnyKey();
            selectionAdd();

        }else {
            System.out.println("---------------------------------------------- LIST CART ITEM -----------------------------------------------");

            float total = 0;
            float sumTotal=0;
            for (Cart cartItem : listCartItem) {
                total = cartItem.getQuantity() * cartItem.getProduct().getPrice();
                System.out.print(cartItem);
                System.out.printf("     Total : %.2f\n", total);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                sumTotal+=total;
            }
            System.out.printf("Total : %.2f\n", sumTotal);
            System.out.println("Enter the any key to continue....");
            InputMethod.pressAnyKey();
            new SelectionFormCart();
        }
    }
    public void selectionAdd(){
        System.out.println("----------- SELECTION -------------");
        System.out.println("1.Add To Cart\t\t\t" +
                "2.Back");
        System.out.println("-----------------------------------");
        System.out.print("Enter the choice : ");
        int choice=InputMethod.getInteger();
        switch (choice){
            case 1:
                new ShowList();
                new AddToCart().addToCart();
                break;
            case 2:
                HomeUser.homeUSer();
                break;
        }
    }


}
