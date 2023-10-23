package view.user.orderForm;

import com.sun.org.apache.xpath.internal.operations.Or;
import config.InputMethod;
import controller.order.OrderController;
import controller.cartController.CartController;
import controller.user.UserController;
import model.entity.Cart;
import model.entity.Order;
import model.entity.User;
import view.user.cart.CartView;
import view.user.userProfile.UserProfile;

import java.util.List;


public class OrderForm {
    public OrderController orderController = new OrderController();
    UserController userController = new UserController();
    User userLogin = userController.getUserLogin();
    List<User> listUser = userController.getListUser();
    List<Order> listOrder = orderController.getListOrder();


    public void checkQuantity() {
        if (orderController.checkNotMatchCart(userLogin.getListCart()).size() != 0) {
            System.err.println("Quantity too in stock!!");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(orderController.checkNotMatchCart(userLogin.getListCart()));

           if (orderController.checkMatchCart(new CartController().getListCart()).size() == 0){
               System.err.println("Please change your quantity or add some product to cart");
           }else {
               selection();
           }

        } else {
            formOrder();
        }
    }

    public void formOrder() {
        Order newOrder = new Order();
        if (listOrder.size() == 0) {
            newOrder.setId(1);
        } else {
            newOrder.setId(listOrder.get(listOrder.size() - 1).getId() + 1);
        }
        System.out.println("<---------- FORM ORDER ---------->");
        System.out.print("Enter the Receive Name : ");
        newOrder.setReceiveName(InputMethod.getString());
        System.out.print("Enter the Receive Telephone : ");
        newOrder.setTelephone(InputMethod.getString());
        System.out.print("Enter the Receive Address : ");
        newOrder.setReceiveAddress(InputMethod.getString());
        System.out.print("Enter the Receive Time : ");
        newOrder.setReceiveTime(InputMethod.getString());
        User userLogin = userController.getUserLogin();

        newOrder.setUser(userLogin);

        newOrder.setListCart(new CartController().getListCart());
        orderController.addToOrder(newOrder);
        orderController.minusPro(newOrder);



        System.out.println("<----------END FORM ORDER -------->");
    }

    public void selection() {
        System.out.println(" Do you still want to order?");
        System.out.println("1. Yes\t\t\t\t" +
                "2. No");
        System.out.print("Enter the choice : ");
        int choice = InputMethod.getInteger();
        switch (choice) {
            case 1:
                formOrder();
                break;
            case 2:
                new CartView().showListCart();
                break;
        }

    }

    public void showHistory() {
        if (listOrder.size() == 0) {
            System.err.println("Order is Empty !!");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("-------------------------------------------------- ORDER HISTORY --------------------------------------------------");
            for (Order b : listOrder) {
                if (b.getUser().getId() == userLogin.getId()) {
                    System.out.println(b.getListCart() + "\n" +
                            "ReceiveName : " + b.getReceiveName() + "\t\t" +
                            "ReceiveAddress :m" + b.getReceiveAddress() + "\t\t" +
                            "Telephone : " + b.getTelephone() + "\t\t" +
                            "ReceiveTime : " + b.getReceiveTime() + "\t\t"
                            + "Status : " + (b.getStatus() == 0 ? "Pending" : b.getStatus() == 1 ? "Shipping" : "Cancel"));
                }
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }
            selectionHistory();
        }
    }

    public void selectionHistory() {
        System.out.println("--------------- Selection ----------------");
        System.out.println("1. Cancel \t\t\t" +
                "2. Back");
        System.out.print("Enter the choice : ");
        int choice = InputMethod.getInteger();
        switch (choice) {
            case 1:
                System.out.print("Enter the Id Order want to cancel : ");
                int id=InputMethod.getInteger();
                for (Order order:listOrder) {
                    if (order.getId()==id){
                        if (order.getStatus()==1){
                            System.err.println("Cancel Dekinai...");
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(" ===>>Cancel Success ");
                    }
                }

//                System.out.println("Cancel Success!");
                break;
            case 2:
                new UserProfile();
                break;
        }
    }


}
