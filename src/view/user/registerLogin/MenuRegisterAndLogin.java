package view.user.registerLogin;

import config.InputMethod;
import view.user.Main;

public class MenuRegisterAndLogin {
    public void HomeRegisterAndLogin() {
        while (true) {
            System.out.println("------------------- Register/Login -------------------");
            System.out.println("\t1. Login\t\t\t" +
                    "2. Register\t\t\t" +
                    "3. Back");

            System.out.println("------------------------------------------------------");
            System.out.print("Enter the choice :");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    new RegisterAndLogin().formLogin();
                    //Chuyển đến login
                    break;
                case 2:
                    // Chuyển đến register
                    new RegisterAndLogin().fomRegister();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                  HomeRegisterAndLogin();
                    break;
                case 3:
                    //Back về trang truớc
                    Main.home();
                    break;
            }
        }
    }

    public void MouLoginOrRegister() {
        while (true) {
            System.out.println("---------------- FORM Register/Login-----------------");
            System.out.println("1. Mou Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("--------------------- END FORM ----------------------");
            System.out.print("Enter the choice :");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    new RegisterAndLogin().formLogin();
                    //Chuyển đến login
                    break;
                case 2:
                    // Chuyển đến register
                    new RegisterAndLogin().fomRegister();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // đăng kí xong chuyển sang đăng nhập
                    break;
                case 3:
                    //Back về trang truớc
                    new Main();
                    break;
            }
        }
    }
}
