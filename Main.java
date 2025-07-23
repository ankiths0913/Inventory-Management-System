import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAOImpl();

        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = sc.next();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    Product p = new Product(name, qty);
                    System.out.println(dao.addProduct(p) ? "Product Added!" : "Failed!");
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.println(dao.updateProduct(pid, newQty) ? "Updated!" : "Failed!");
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = sc.nextInt();
                    System.out.println(dao.deleteProduct(did) ? "Deleted!" : "Failed!");
                    break;

                case 4:
                    List<Product> products = dao.getAllProducts();
                    System.out.println("\n--- Products ---");
                    for (Product prod : products) {
                        System.out.println("ID: " + prod.getId() + ", Name: " + prod.getName() + ", Quantity: " + prod.getQuantity());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
