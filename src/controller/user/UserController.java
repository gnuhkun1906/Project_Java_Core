package controller.user;

import config.Message;
import dto.request.SignInDTO;
import dto.request.SignUpDTO;
import dto.response.ResponseMessage;
import model.RoleInterface.IRole;
import model.RoleInterface.RoleIPLM;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import model.role.Role;
import model.role.RoleName;
import model.service.User.UserServiceIPLM;
import model.service.User.IUserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    IUserService userService = new UserServiceIPLM();
    IRole roleService = new RoleIPLM();

    public List<User> getListUser() {
        return userService.findAll();
    }

    public ResponseMessage register(SignUpDTO sign) {
        if (userService.checkExistUserName(sign.getUserName())) {
            return new ResponseMessage(Message.EXIST_USERNAME);
        }
        if (userService.checkExistEmail(sign.getEmail())) {
            return new ResponseMessage(Message.EXIST_EMAIL);
        }
        Set<Role> roleSet = new HashSet<>();
        Set<String> strRole = sign.getStrRole();
        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    roleSet.add(roleService.findByName(RoleName.ADMIN));
                    break;
                case "user":
                    roleSet.add(roleService.findByName(RoleName.USER));
                    break;

            }
        });
        List<Cart> cartItemList = new ArrayList<>();

        User user = new User(sign.getId(), sign.getUserName(), sign.getFullName(), sign.getEmail(), sign.getPassword(), roleSet, cartItemList);
        userService.save(user);
        return new ResponseMessage(Message.SUCCESS_REGISTER);
    }

    public ResponseMessage login(SignInDTO signIn) {
        if (userService.checkLogin(signIn.getUserName(), signIn.getPassword())) {
            return new ResponseMessage(Message.LOGIN_SUCCESS);
        } else {
            return new ResponseMessage(Message.LOGIN_FAIL);
        }
    }

    public User getUserLogin() {
        return (User) userService.getCurrentUser();
    }

    public void logOutUser() {
        userService.logOut();
    }

    public void changePassword(String password) {
        userService.changePassword(password);
    }

    public void updateTelephone(String telephone) {
        userService.updateTelephone(telephone);
    }

    public void updateAddress(String address) {
        userService.updateAddress(address);
    }

    public void updateCardNumber(String card) {
        userService.updateCard(card);
    }

    public User findById(int id) {
        return userService.findById(id);
    }
}
