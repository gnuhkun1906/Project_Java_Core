package view.user.userProfile;

import controller.user.UserController;
import model.entity.User;

import java.util.List;

public class InfoUser {
    UserController userController = new UserController();
    User userLogin = userController.getUserLogin();

    public InfoUser() {
//        System.out.println(userLogin);
        if (userLogin.getAddress()==null){
            userLogin.setAddress("Chưa cập nhật !!");
        }
        if (userLogin.getCardNumber()==null){
            userLogin.setCardNumber("Chưa cập nhật!!");
        }
        if (userLogin.getTelephone()==null){
            userLogin.setTelephone("Chưa cập nhật!!");
        }
        System.out.println("-------------- INFO USER --------------");
            System.out.println("\tUserId : " + userLogin.getId() + "\n"
                    + "\tUserName : " + userLogin.getUserName() + "\n"
                    + "\tEmail : " + userLogin.getEmail() + "\n"
                    + "\tPassword : " + userLogin.getPassword() + "\n"
                    + "\tTelephone : " + (userLogin.getTelephone()) + "\n"
                    + "\tCard Number : " + userLogin.getCardNumber() + "\n"
                    + "\tAddress : " + userLogin.getAddress() );
        System.out.println("---------------------------------------");
        }
    }

