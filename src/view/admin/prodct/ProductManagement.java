package view.admin.prodct;

import config.InputMethod;
import view.admin.HomeAdmin;
import view.admin.category.CreateCategory;
import view.admin.category.DeleteCategory;
import view.admin.category.ShowListCategory;
import view.admin.category.UpdateCategory;

public class ProductManagement {
    public static void main(String[] args) {
        new ProductManagement();
    }
    public ProductManagement() {
        while (true) {
            System.out.println("   ------------------------------ PRODUCT MANAGEMENT ------------------------------");
            System.out.println("1.Create Product\t" +
                    "2.Update Product\t" +
                    "3.Delete Product\t" +
                    "4.Show List Product\t\t" +
                    "5.Back");
            System.out.println("   --------------------------------------------------------------------------------");

            System.out.print("Enter the choice : ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    //Tạo mới category
                    new CreateProduct();
                    System.out.println("Enter the any key to continue....");
                    InputMethod.pressAnyKey();
                    break;
                case 2:
                    //Chỉnh sửa category
                    new UpdateProduct();
                    System.out.println("Enter the any key to continue....");
                    InputMethod.pressAnyKey();
                    break;
                case 3:
                    //Xóa category
                    new DeleteProduct();
                    System.out.println("Enter the any key to continue....");
                    InputMethod.pressAnyKey();
                    break;
                case 4:
                    //Showlist category
                    new ShowListProduct();
                    System.out.println("Enter the any key to continue....");
                    InputMethod.pressAnyKey();
                    break;
                case 5:
                    // Back
                    new HomeAdmin();
                    break;
            }
        }
    }
}

