package model.service.User;

import config.Config;
import dataURL.Path;
import model.entity.User;
import model.service.User.IUserService;

import java.io.PrintWriter;
import java.util.List;

public class UserServiceIPLM implements IUserService {
    List<User> listUser = new Config<User>().readFromFile(Path.PATH_USER);
    List<User> currentUser = new Config<User>().readFromFile(Path.PATH_USER_LOGIN);


    @Override
    public List<User> findAll() {
        return listUser;
    }

    @Override
    public void save(User user) {
        listUser.add(user);
        new Config<User>().writeToFile(Path.PATH_USER, listUser);
    }

    @Override
    public User findById(int id) {
        for (User u:listUser) {
            if (u.getId()==id){
                return u;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User inputData() {
        return null;
    }

    @Override
    public boolean checkExistUserName(String userName) {
        for (User user : listUser) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkExistEmail(String email) {
        for (User user : listUser) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        List<User> userLogin = new Config<User>().readFromFile(Path.PATH_USER_LOGIN);
        for (User user : listUser) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userLogin.add(user);
                new Config<User>().writeToFile(Path.PATH_USER_LOGIN, userLogin);
                return true;
            }
        }
        return false;
    }

    @Override
    public User getCurrentUser() {
        if (currentUser.size() != 0) {
            User user = currentUser.get(0);
            return user;
        }
        return null;
    }

    public void logOut() {
        if (currentUser != null) {
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(Path.PATH_USER_LOGIN);
                printWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changePassword(String password) {
        getCurrentUser().setPassword(password);
        new Config<User>().writeToFile(Path.PATH_USER_LOGIN,currentUser);

    }

    @Override
    public void updateTelephone(String telephone) {
        getCurrentUser().setTelephone(telephone);
        new Config<User>().writeToFile(Path.PATH_USER_LOGIN,currentUser);
    }

    @Override
    public void updateAddress(String address) {
        getCurrentUser().setAddress(address);
        new Config<User>().writeToFile(Path.PATH_USER_LOGIN,currentUser);
    }

    @Override
    public void updateCard(String card) {
        getCurrentUser().setCardNumber(card);
        new Config<User>().writeToFile(Path.PATH_USER_LOGIN,currentUser);
    }
}
