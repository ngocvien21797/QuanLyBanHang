import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        manager.addSampleProducts();

        while (true) {
            System.out.println("\n=== QUẢN LÝ SẢN PHẨM ===");
            System.out.println("1. Xem tất cả sản phẩm");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Hiển thị theo giá");
            System.out.println("4. Hiển thị theo danh mục");
            System.out.println("5. Tổng giá trị tồn kho theo danh mục");
            System.out.println("6. Giảm giá sản phẩm");
            System.out.println("7. Đặt hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // tránh lỗi

            switch (choice) {
                case 1: manager.showAll(); break;
                case 2: manager.updateProduct(sc); break;
                case 3: manager.displayByPrice(); break;
                case 4:
                    System.out.print("Nhập tên danh mục: ");
                    String cat = sc.nextLine();
                    manager.displayByCategory(cat); break;
                case 5: manager.totalByCategory(); break;
                case 6:
                    System.out.print("Nhập % giảm giá: ");
                    double percent = sc.nextDouble();
                    manager.discount(percent); break;
                case 7: manager.order(sc); break;
                case 0: System.out.println("Thoát!"); return;
                default: System.out.println("Sai lựa chọn!");
            }
        }
    }
}
