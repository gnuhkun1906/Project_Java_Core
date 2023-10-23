package view.admin.category;

import config.InputMethod;
import view.admin.HomeAdmin;

public class CategoryManagement {
    public static void main(String[] args) {
        new CategoryManagement();
    }
    public CategoryManagement() {
        while (true) {
            System.out.println("------------------------------------------- CATEGORY MANAGEMENT -------------------------------------------");
            System.out.print("1.Create Category\t\t");
            System.out.print("2.Update Category\t\t");
            System.out.print("3.Delete Category\t\t");
            System.out.print("4.Show List Category\t\t");
            System.out.println("5.Back");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.print("Enter the choice : ");
          int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    //Tạo mới category
                    new CreateCategory();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                    break;
                case 2:
                    //Chỉnh sửa category
                    new UpdateCategory();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                    break;
                case 3:
                    //Xóa category
                    new DeleteCategory();
                    System.out.println("Enter the any key to continue...");
                    InputMethod.pressAnyKey();
                    break;
                case 4:
                    //Showlist category
                    new ShowListCategory();
                    System.out.println("Enter the any key to continue...");
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
