package view.user.cart;

import config.InputMethod;
import view.user.HomeUser;
import view.user.orderForm.OrderForm;

public class SelectionFormCart {
    public SelectionFormCart() {
        System.out.println("-------------------------------- SELECTION ------------------------------------");
        System.out.println("1. Order all\t" +
                "2. Delete Product\t" +
                "3. Edit Quantity\t" +
                "4. Mou think<Back>");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Enter the choice : ");
        int choice= InputMethod.getInteger();
        switch (choice){
            case 1:
                // order ngay
                new OrderForm().checkQuantity();
//                new ListBill();
                break;
            case 2:
                //Xóa sản phẩm bạn không muốn mua
                new DeleteProduct();
                break;
            case 3:
                // điều chỉnh số lượng
                new EditQuantity();
                break;
            case 4:
                // suy nghĩ lại và  back
                HomeUser.homeUSer();
                break;
        }
    }
}
