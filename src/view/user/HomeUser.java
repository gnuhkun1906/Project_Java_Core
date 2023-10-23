package view.user;

import config.InputMethod;
import controller.user.UserController;
import view.admin.prodct.SearchProductByName;
import view.user.cart.CartView;
import view.user.product.SelectionProduct;
import view.user.userProfile.UserProfile;

public class HomeUser {
    public static void homeUSer() {
            while (true) {
                System.out.println("-------------------------------- HOMEPAGE -----------------------------------");
                System.out.print("1. Menu\t\t");
                System.out.print("2. Search\t\t");
                System.out.print("3. Cart\t\t");
                System.out.print("4. User Profile\t\t");
                System.out.println("5. LogOut ");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.print("Enter the choice : ");
                int choice = InputMethod.getInteger();
                switch (choice) {
                    case 1:
                        new Menu();
                        System.out.println("Enter the any key to continue....");
                        InputMethod.pressAnyKey();
                        new SelectionProduct();
                        break;
                    case 2:
                        //Chuyển đến Search
                        new SearchProductByName();
                        System.out.println("Enter the any key to continue....");
                        InputMethod.pressAnyKey();
                        break;
                    case 3:
                        //Chuyển đến Cart
                        new CartView().showListCart();
                        break;
                    case 4:
                        //chuyển đến User Profile
                        new UserProfile();
                        break;
                    case 5:
                        //LogOut
                        logOut();
                        Main.home();
                        break;
                }
            }
        }


    public static void logOut() {
        new UserController().logOutUser();
    }

}
