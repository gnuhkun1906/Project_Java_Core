package view.user.userProfile;

import config.InputMethod;
import view.user.HomeUser;
import view.user.orderForm.OrderForm;


public class UserProfile {
    public UserProfile() {
        System.out.println("--------------------------- USER PROFILE ---------------------------");
        System.out.println("1.Info User\t\t" +
                "2.Order History\t\t" +
                "3.Update User\t\t" +
                "4.Back");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Enter the choice : ");
        int choice = InputMethod.getInteger();
        switch (choice) {
            case 1:
                new InfoUser();
                System.out.println("Enter the any key to continue....");
                InputMethod.pressAnyKey();
                new UserProfile();
                break;
            case 2:
                new OrderForm().showHistory();
                break;
            case 3:
                new UpdateUser();
                break;
            case 4:
                new HomeUser();
                break;
        }

    }
}
