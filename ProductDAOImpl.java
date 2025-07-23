import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements ProductDAO {
    Connection conn = DBConnect.getConnection();

    public boolean addProduct(Product p) {
        try {
            String sql = "INSERT INTO products(name, quantity) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQuantity());
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(int id, int quantity) {
        try {
            String sql = "UPDATE products SET quantity=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        try {
            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
