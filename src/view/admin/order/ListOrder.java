package view.admin.order;

import config.InputMethod;
import controller.order.OrderController;
import controller.user.UserController;
import model.entity.Order;
import model.entity.User;
import view.admin.HomeAdmin;

import java.util.List;

public class ListOrder {
    private OrderController orderController = new OrderController();
    //    List<Cart> listCart=
    UserController userController = new UserController();
    User userLogin = userController.getUserLogin();
    List<Order> listOrder=orderController.getListOrder();

    public ListOrder() {
        if (listOrder.size() == 0 ){
            System.err.println("List Order is Empty!!");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enter the any key to continue....");
            InputMethod.pressAnyKey();
            new HomeAdmin();
        } else {
            System.out.println("------------------------------------------- LIST ORDER ------------------------------------------");
            for (Order list : orderController.getListOrder()) {
                System.out.println("Id : "+list.getId()+"\n"+
                        "FullName : " + userLogin.getFullName() + "\n"
                        + list.getListCart() + "\n" +
                        "ReceiveName : " + list.getReceiveName() + "\n" +
                        "ReceiveAddress :m" + list.getReceiveAddress() + "\n" +
                        "Telephone : " + list.getTelephone() + "\n" +
                        "ReceiveTime : " + list.getReceiveTime() + "\n"
                        + "Status : " + (list.getStatus()==0?"Pending...":list.getStatus()==1?"Confirmed":"Cancel") + "\n");
                System.out.println("-------------------------------------------------------------------------------------------------");

            }
        }
    }
}
