package view.admin.user;

import config.Config;
import config.InputMethod;
import controller.user.UserController;
import dataURL.Path;
import model.entity.User;

import java.util.List;

public class ListUser {
    UserController userController=new UserController();
    List<User> listUser=userController.getListUser();

    public ListUser() {
        System.out.println("  --------------- Selection ---------------");
        System.out.println("1. Show list User\t\t\t" +
                "2. Change Status");
        System.out.println("  -----------------------------------------");

        System.out.print("Enter the choice :  ");
        int choice= InputMethod.getInteger();
        switch (choice){
            case 1:
                showListUser();
                break;
            case 2:
            //Thay đổi status
                changeStatus();
                break;

        }
    }
    public void showListUser(){
        System.out.println("\t\t------------------------------------------------- List User -------------------------------------------------");
        for (User u:listUser) {
            System.out.println("UserId : "+ u.getId() +"\t"
                    +"UserName : "+ u.getUserName()+"\t"
                    +"Email : "+ u.getEmail()+"\t"
                    +"Password : " +u.getPassword()+"\t"
                    +"Status : "+ u.isStatus()+"\t"
                    +"Role : "+u.getRoles());
        }
        System.out.println("\t\t-------------------------------------------------------------------------------------------------------------");

    }
    public void changeStatus(){
        showListUser();
        System.out.print("Enter the Id User want to change status : ");
       User user=userController.findById(InputMethod.getInteger());
       if (user.getId()==1){
           System.err.println(" DEKINAI !!");
           try {
               Thread.sleep(50);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }else {
           user.setStatus(!user.isStatus());
           System.out.println("===> Change Status ");
       }
       new Config<User>().writeToFile(Path.PATH_USER,listUser);
    }

}
