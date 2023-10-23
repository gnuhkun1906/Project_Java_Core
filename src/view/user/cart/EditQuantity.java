package view.user.cart;

import config.InputMethod;
import config.Message;
import controller.cartController.CartController;

public class EditQuantity {
    CartController cartController=new CartController();
    public EditQuantity() {
        System.out.println("----------------- Edit Quantity -----------------");
        System.out.print("Enter the Id Product want to edit Quantity :  ");
        int idPro= InputMethod.getInteger();
        System.out.print("Enter the Quantity want to change  ==>> ");
        int quantity=InputMethod.getInteger();
       cartController.editQuantity(idPro,quantity);

        System.out.println("-------------------------------------------------");
    }
}
