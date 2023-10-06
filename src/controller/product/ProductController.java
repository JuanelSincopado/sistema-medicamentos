package controller.product;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import model.Product;

import static db.Database.conn;

public class ProductController {
  static Connection connection = conn();

  static public List<Product> getProductsTop() {
    List<Product> productList = new ArrayList<>();

    try {
      Statement st = connection.createStatement();

      ResultSet rs = st.executeQuery("SELECT * FROM product ORDER BY sold DESC LIMIT 3");

      while (rs.next()) {
        int product_id = rs.getInt("product_id");
        String nombre = rs.getString("name");
        String brand = rs.getString("brand");
        String category = rs.getString("category");
        String subCategory = rs.getString("subCategory");
        int stock = rs.getInt("stock");
        int vendido = rs.getInt("sold");
        String price = rs.getString("price");
        String description = rs.getString("description");
        Date creationDate = rs.getDate("creationDate");
        Date expirationDate = rs.getDate("expirationDate");
        Product newProduct = new Product(product_id, nombre, brand, category, subCategory, stock, vendido, price,
            description, creationDate, expirationDate);
        productList.add(newProduct);
      }
    } catch (SQLException e) {
      System.out.println(e);
    }

    return productList;
  }
}
