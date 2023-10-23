package view.admin.order;

import config.Config;
import config.InputMethod;
import controller.order.OrderController;
import dataURL.Path;
import model.entity.Order;
import view.admin.HomeAdmin;

public class SelectionForm {
    OrderController orderController = new OrderController();

    public SelectionForm() {
        System.out.println("----------------- SELECTION -----------------");
        System.out.print("1. Confirm \t\t");
        System.out.print("2. Cancel \t\t");
        System.out.println("3. Back ");
        System.out.println("---------------------------------------------");
        System.out.print("Enter the choice : ");
        int choice = InputMethod.getInteger();
        switch (choice) {
            case 1:
                confirm();
                break;
            case 2:
                cancel();
                break;
            case 3:
                new HomeAdmin();
                break;
        }
    }

    public void confirm() {
        System.out.print("Enter the Id User want to confirm : ");
        Order order = orderController.findById(InputMethod.getInteger());
        order.setStatus((byte) 1);
        System.out.println("===>> Confirm Success !");
        new Config<Order>().writeToFile(Path.PATH_ORDER,orderController.getListOrder());
    }
    public void cancel(){
        System.out.print("Enter the Id Order want to cancel : ");
        Order order=orderController.findById(InputMethod.getInteger());
        order.setStatus((byte) 2);

        new Config<Order>().writeToFile(Path.PATH_ORDER,orderController.getListOrder());
    }

}
