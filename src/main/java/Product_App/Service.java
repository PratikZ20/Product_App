package Product_App;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO
public class Service {
    private static Connection conn = null;

    static {
        String url = "jdbc:mysql://localhost:3306/productdbapp";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String selectQuery = "SELECT * FROM product";
        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");
                int productQuantity = resultSet.getInt("productQty");

                Product product = new Product(productId, productName, productPrice, productQuantity);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;

    }

    public int addNewProduct(Product newProduct) {
        int n = 0;
        String insertQuery = "insert into product values(?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, newProduct.getProductId());
            pstmt.setString(2, newProduct.getProductName());
            pstmt.setDouble(3, newProduct.getProductPrice());
            pstmt.setInt(4, newProduct.getProductQuantity());
            int q = pstmt.executeUpdate();
            System.out.println(q);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int deleteProductByName(String productName) {
        int rowsDeleted = 0;
        String deleteQuery = "DELETE FROM product WHERE productName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            pstmt.setString(1, productName);

            rowsDeleted = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rowsDeleted;
    }
    public int updateProductByName(String productName, double newPrice) {
        int rowsUpdated = 0;
        String updateQuery = "UPDATE product SET productPrice = ? WHERE productName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setString(2, productName);

            rowsUpdated = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsUpdated;
    }



}
