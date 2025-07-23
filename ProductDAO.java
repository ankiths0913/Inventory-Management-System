import java.util.*;

public interface ProductDAO {
    boolean addProduct(Product p);
    boolean updateProduct(int id, int quantity);
    boolean deleteProduct(int id);
    List<Product> getAllProducts();
}
