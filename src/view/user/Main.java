package view.user;

import config.InputMethod;
import controller.user.UserController;
import model.entity.Product;
import model.entity.User;
import model.role.Role;
import model.role.RoleName;
import view.admin.HomeAdmin;
import view.admin.prodct.SearchProductByName;
import view.admin.prodct.ShowListProduct;
import view.user.registerLogin.MenuRegisterAndLogin;
import view.user.registerLogin.RegisterAndLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static User currentUser;

    public static void home() {
        currentUser = new UserController().getUserLogin();
        if (currentUser != null) {
            Set<Role> roleSet = currentUser.getRoles();
            List<Role> roles = new ArrayList<>(roleSet);
            if (roles.get(0).getName() == RoleName.ADMIN) {
                new HomeAdmin();
            } else if (roles.get(0).getName() == RoleName.USER && !currentUser.isStatus()){
                System.out.println("\t\t\t\t\t<<-----------WELCOME " + currentUser.getUserName() + "------------>>");
                new HomeUser().homeUSer();
            }else if (currentUser != null && currentUser.isStatus()){
                new UserController().logOutUser();
                System.err.println("Account is Blocked!!");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                homeUser();
            }
        }else {homeUser();}
    }

    private static void homeUser() {
        while (true) {
            System.out.println("------------------------------ HOMEPAGE --------------------------------");
            System.out.println("1. Register/Login\t\t" +
                    "2. Menu\t\t" +
                    "3. Search\t\t" +
                    "4. Cart\t\t" +
                    "5.Exit");
            System.out.println("------------------------------------------------------------------------");
            System.out.print("Enter the choice : ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    //Chuyển đến Register/login
                    new MenuRegisterAndLogin().HomeRegisterAndLogin();
                    break;
                case 2:
                    //Chuyển đến Menu Product
                    new Menu();

                    break;
                case 3:
                    //Chuyển đến Search
                        new SearchProductByName();
                    break;
                case 4:
                    //chuyển đến Cart
                    if (currentUser==null){
                        System.err.println("please Login.....");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        new RegisterAndLogin().formLogin();
                    }
                    break;
                case 5:
                    System.out.println("<<===========GOODBYE===========>>");
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        home();
    }
}
