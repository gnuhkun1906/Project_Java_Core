package model.service.User;

import model.entity.User;
import model.service.IGenericService;

public interface IUserService extends IGenericService<User> {

    boolean checkExistUserName(String userName);
    boolean checkExistEmail(String email);
    boolean checkLogin(String userName,String password);
    User getCurrentUser();
    void logOut();
    void changePassword(String password);
    void updateTelephone(String telephone);
    void updateAddress(String address);
    void updateCard(String card);
}
