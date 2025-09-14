import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addSampleProducts() {
        products.add(new Product(1, "Iphone 7", 1000, "Điện thoại Apple", "Điện tử", 5));
        products.add(new Product(2, "Iphone 8", 20, "Điện thoại Apple", "Điện tử", 10));
        products.add(new Product(3, "Iphone 9s", 800, "Điện thoại Apple", "Điện tử", 3));
    }

    // 1) Cập nhật thông tin sản phẩm
    public void updateProduct(Scanner sc) {
    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
    int id = sc.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
            System.out.print("Nhập giá mới: ");
            p.setPrice(sc.nextDouble());
            sc.nextLine(); 
            System.out.print("Nhập mô tả mới: ");
            p.setDescription(sc.nextLine());
            System.out.println("Đã cập nhật!");
             return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    // 2) Hiển thị danh sách theo giá hoặc danh mục
   public void displayByPrice() {
    for (int i = 0; i < products.size() - 1; i++) {
        for (int j = i + 1; j < products.size(); j++) {
            if (products.get(i).getPrice() > products.get(j).getPrice()) {
            Product tmp = products.get(i);
            products.set(i, products.get(j));
            products.set(j, tmp);
            }
        }
    }
    for (Product p : products) {
    System.out.println(p);
    }
}

  public void displayByCategory(String category) {
    for (Product p : products) {
        if (p.getCategory().equalsIgnoreCase(category)) {
        System.out.println(p);
        }
    }
}

    // 3) Tổng giá trị tồn kho cho từng danh mục
  public void totalByCategory() {
    // Duyệt qua từng sản phẩm và tính theo danh mục
    ArrayList<String> danhMucDaTinh = new ArrayList<>();
    for (Product p : products) {
        String cat = p.getCategory();
        if (!danhMucDaTinh.contains(cat)) {
        double sum = 0;
            for (Product q : products) {
                if (q.getCategory().equalsIgnoreCase(cat)) {
                sum += q.getPrice() * q.getQuantity();
                }
            }
            System.out.println(cat + ": " + sum);
            danhMucDaTinh.add(cat);
        }
    }
}


    // 4) Giảm giá
    public void discount(double percent) {
        for (Product p : products) {
            double newPrice = p.getPrice() * (1 - percent / 100);
            p.setPrice(newPrice);
        }
        System.out.println("Đã áp dụng giảm giá " + percent + "% cho tất cả sản phẩm!");
    }

    // 5) Đặt hàng
    public void order(Scanner sc) {
        System.out.print("Nhập ID sản phẩm muốn mua: ");
        int id = sc.nextInt();
        System.out.print("Nhập số lượng: ");
        int qty = sc.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                if (qty <= p.getQuantity()) {
                double total = qty * p.getPrice();
                p.setQuantity(p.getQuantity() - qty);
                System.out.println("Đặt hàng thành công! Tổng tiền: " + total);
                } else {
                System.out.println("Không đủ hàng tồn kho!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    public void showAll() {
    products.forEach(System.out::println);
    }
}
