public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int quantity;

    public Product(int id, String name, double price, String description, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter và Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return id + " - " + name + " | Giá: " + price + " | Số lượng: " + quantity + " | " + category + " | " + description;
    }
}
