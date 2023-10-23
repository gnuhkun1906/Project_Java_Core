package view.user.product;

import config.InputMethod;
import view.user.HomeUser;
import view.user.Menu;
import view.user.orderForm.OrderForm;

public class SelectionProduct {
    public SelectionProduct() {
        System.out.println("----------------- SELECTION -----------------");
        System.out.print("\t1. Add To Cart         ");
        System.out.println("    2.Back ");
        System.out.println("---------------------------------------------");
        System.out.print("Enter the choice : ");
        int choice= InputMethod.getInteger();
        switch (choice){
            case 1:
                //Thêm vào giỏ hàng
                new AddToCart().addToCart();
                System.out.println("Enter  the any key to continue....");
                new Menu();
                break;
            case 2:
                //Back về menu trước
               HomeUser.homeUSer();
                break;

        }
    }
}
