package view.admin;

import config.InputMethod;
import controller.user.UserController;
import view.admin.category.CategoryManagement;
import view.admin.order.ListOrder;
import view.admin.order.SelectionForm;
import view.admin.prodct.ProductManagement;
import view.admin.user.ListUser;
import view.user.Main;

public class HomeAdmin {

    public HomeAdmin() {
        while (true) {
            System.out.println("--------------------------------------------------- HOME ADMIN --------------------------------------------------");
            System.out.print("1.User Management\t\t");
            System.out.print("2.Category Management\t\t");
            System.out.print("3.Product Management\t\t");
            System.out.print("4.Order Management\t\t");
            System.out.println("5.LogOut");
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.print("Enter the choice : ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    // quản lí user
                        new ListUser();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                    break;
                case 2:
                    // Category
                    new CategoryManagement();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                    break;
                case 3:
                    // Menu quản lí Product
                    new ProductManagement();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                    break;
                case 4:
                    //Quản lí đơn hàng order
                    new ListOrder();
                    System.out.println("Enter the any key to continue....");
                    InputMethod.pressAnyKey();
                    new SelectionForm();
                    break;
                case 5:
                    new UserController().logOutUser();
                   Main.home();
            }
        }
    }
}
