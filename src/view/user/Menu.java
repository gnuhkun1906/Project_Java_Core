package view.user;

import config.InputMethod;
import controller.product.ProductController;
import model.entity.Product;
import view.admin.category.ShowListCategory;
import view.user.product.SelectionProduct;
import view.user.product.ShowList;

public class Menu {
    public Menu() {
        System.out.println("------------------- MENU ---------------------");
        System.out.println("1.Category \t\t\t" +
                "2.Product\t\t\t" +
                "3.Back");
        System.out.println("----------------------------------------------");
        System.out.print("Enter the choice : ");
        int choice = InputMethod.getInteger();
        switch (choice) {
            case 1:
                new ShowListCategory();
                System.out.println("Enter the any key to continue ....");
                InputMethod.pressAnyKey();
                selection();
                break;
            case 2:
                new ShowList().showListProduct();
                System.out.println("Enter the any key to continue ....");
                InputMethod.pressAnyKey();
               new SelectionProduct();
                break;
            case 3:
                HomeUser.homeUSer();
                break;

        }
    }

    public void selection() {
        boolean check = false;
        System.out.print("Enter the Id Category : ");
        int choice = InputMethod.getInteger();
        for (Product pro : new ProductController().getListProduct()) {
            if (pro.getCategory().getCategoryId() == choice) {
                System.out.println(pro);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Category not found!!");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enter the any key to continue ....");
            InputMethod.pressAnyKey();
            new Menu();
        }

    }

}
