package view.user.registerLogin;

import config.InputMethod;
import config.Validate;
import controller.user.UserController;
import config.Message;
import dto.request.SignInDTO;
import dto.request.SignUpDTO;
import dto.response.ResponseMessage;
import model.entity.User;
import view.user.HomeUser;
import view.user.Main;
import view.user.registerLogin.MenuRegisterAndLogin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegisterAndLogin {
    UserController userController = new UserController();
    List<User> listUser = userController.getListUser();
    public void fomRegister() {
        SignUpDTO sign = new SignUpDTO();
        String role="user";
        int id = 0;
        if (listUser.size() == 0) {
            id = 1;
            sign.setId(id);
             role="admin";
        } else {
            id = listUser.get(listUser.size() - 1).getId() + 1;
            sign.setId(id);
        }

        while (true) {
            System.out.print("Enter the fullName : ");
            String fullName = InputMethod.getString();
            if (!Validate.checkValidateFullName(fullName)) {
                try {
                    System.err.println(Message.ILLEGAL_FULLNAME);
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                sign.setFullName(fullName);
                break;
            }
        }
        System.out.print("Enter the userName : ");
        String userName = InputMethod.getString();
        sign.setUserName(userName);

        while (true) {
            System.out.print("Enter the email : ");
            String email = InputMethod.getString();
            if (!Validate.checkValidateEmail(email)) {
                try {
                    System.err.println(Message.ILLEGAL_EMAIL);
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                sign.setEmail(email);
                break;
            }
        }
        while (true) {
            System.out.print("Enter the password : ");
            String password = InputMethod.getString();
            if (!Validate.checkValidatePassword(password)) {
                try {
                    System.err.println(Message.ILLEGAL_PASSWORD);
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                sign.setPassword(password);
                break;
            }
        }
        while (true) {
            System.out.print("Enter the rePassword : ");
            String rePassword = InputMethod.getString();
            if (!rePassword.matches(sign.getPassword())) {
                try {
                    System.err.println(Message.NOT_EXISTPASSWORD);
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                sign.setRePassword(rePassword);
                break;
            }
        }
        sign.setStatus(true);
        Set<String> roleSet=new HashSet<>();
        roleSet.add(role);
        sign.setStrRole(roleSet);
        ResponseMessage message = userController.register(sign);
        if (message.getMessage().equals(Message.EXIST_USERNAME)) {
            try {
                System.err.println(Message.ERR_USERNAME);
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fomRegister();
        }
        if (message.getMessage().equals(Message.EXIST_EMAIL)) {

            try {
                System.err.println(Message.ERR_EMAIL);
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fomRegister();
        }
        if (message.getMessage().equals(Message.SUCCESS_REGISTER)) {
            System.out.println(Message.SUCCESS_REGISTER);
        }
    }
    public void formLogin() {
        while (true) {
            System.out.println("----------- FORM LOGIN -----------");
            System.out.print("Enter th UserName : ");
            String userName=InputMethod.getString();
            System.out.print("Enter the Password : ");
            String password=InputMethod.getString();
            System.out.println("----------------------------------");
            SignInDTO signIn=new SignInDTO(userName,password);

            ResponseMessage responseMessage=userController.login(signIn);
            if (responseMessage.getMessage().equals(Message.LOGIN_FAIL)){
                try {
                    System.err.println(Message.NOTIFY_LOGIN_FAIL);
                    Thread.sleep(50);
                }catch (Exception e){
                    e.printStackTrace();
                }
                new MenuRegisterAndLogin().MouLoginOrRegister();
            }else {
                System.out.println(Message.LOGIN_SUCCESS);
                //Chuyển vào trang chủ
                Main.home();
                break;
            }

        }
    }
}
