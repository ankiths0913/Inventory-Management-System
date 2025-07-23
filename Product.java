public class Product {
    private int id;
    private String name;
    private int quantity;

    // Constructors
    public Product() {}

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
