package view.user.userProfile;

import config.InputMethod;
import controller.user.UserController;

public class UpdateUser {
    UserController userController = new UserController();

    public UpdateUser() {
        System.out.println("<------ UPDATE USER ------->");
        System.out.println("1. Update Telephone ");
        System.out.println("2. Update Address");
        System.out.println("3. Update Ginkou Card");
        System.out.println("4. Change Password");
        System.out.println("5. Back");
        System.out.print("Enter the choice : ");
        int choice = InputMethod.getInteger();
        switch (choice) {
            case 1:
                updateTelephone();
                System.out.println("Enter the any key to continue....");
                InputMethod.pressAnyKey();
                new UpdateUser();
                break;
            case 2:
                updateAddress();
                System.out.println("Enter the any key to continue....");
                InputMethod.pressAnyKey();
                new UpdateUser();
                break;
            case 3:
                updateCardNumber();
                System.out.println("Enter the any key to continue....");
                InputMethod.pressAnyKey();
                new UpdateUser();
                break;
            case 4:
                changePassword();
                System.out.println("Enter the any key to continue....");
                InputMethod.pressAnyKey();
                new UpdateUser();
                break;
            case 5:
                new UserProfile();
                break;
        }

    }

    public void updateTelephone() {
        System.out.print("Enter the telephone : ");
        userController.updateTelephone(InputMethod.getString());
    }

    public void updateAddress() {
        System.out.print("Enter the Address : ");
        userController.updateAddress(InputMethod.getString());
    }

    public void updateCardNumber() {
        System.out.println("Enter the cardNumber : ");
        userController.updateCardNumber(InputMethod.getString());
    }
    public void changePassword() {
        System.out.print("New Password ====>>> ");
        userController.changePassword(InputMethod.getString());

    }

}
