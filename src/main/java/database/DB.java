package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilities.structure.ProductInformation;
import utilities.structure.ProductUpdate;

public class DB {

	public static String url;
	public static String user;
	public static String password;
	public static Connection conn;
	private static DB db;

	public static DB getDb() {
		if (db == null) {
			db = new DB();
			System.out.println("db working");
		}

		return db;
	}

	private DB() {
		try {

			String url = "jdbc:sqlite:warehouse.db"; // SQLite connection string
			// connection
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			String create_adminTable = "CREATE TABLE IF NOT EXISTS admins_info (" + "admin_id TEXT NOT NULL UNIQUE, "
					+ "username TEXT, " + "password TEXT, " + "PRIMARY KEY (username, password)" + ");";

			String create_productTable = "CREATE TABLE IF NOT EXISTS products (" + "product_id INTEGER PRIMARY KEY, "
					+ "product_name TEXT, " + "price INTEGER, " + "quantity INTEGER, " + "PRCStrategy TEXT, "
					+ "MaxQuantity INTEGER, " + "MinQuantity INTEGER, " + "RestQuantity INTEGER" + ");";

			statement.executeUpdate(create_adminTable);
			statement.executeUpdate(create_productTable);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	// Method to add data to products table
	public void addProduct(String productName, double price, int quantity, String prcStrategy, int maxQuantity,
			int minQuantity, int restQuantity) {
		try {
			String insertProductQuery = "INSERT INTO products (product_name, price, quantity, PRCStrategy, MaxQuantity, MinQuantity, RestQuantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insertProductQuery);
			pstmt.setString(1, productName);
			pstmt.setDouble(2, price);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, prcStrategy);
			pstmt.setInt(5, maxQuantity);
			pstmt.setInt(6, minQuantity);
			pstmt.setInt(7, restQuantity);

			pstmt.executeUpdate();

			System.out.println("Product added successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to retrieve data from products table
	 public void getProduct() {
	        try {
	            String selectProductsQuery = "SELECT * FROM products";
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery(selectProductsQuery);

	            while (resultSet.next()) {
	                int productId = resultSet.getInt("product_id");
	                String productName = resultSet.getString("product_name");
	                double price = resultSet.getDouble("price");
	                int quantity = resultSet.getInt("quantity");
	                String prcStrategy = resultSet.getString("PRCStrategy");
	                int maxQuantity = resultSet.getInt("MaxQuantity");
	                int minQuantity = resultSet.getInt("MinQuantity");
	                int restQuantity = resultSet.getInt("RestQuantity");

	                System.out.println("Product ID: " + productId + ", Product Name: " + productName + ", Price: " + price + ", Quantity: " + quantity + ", PRC Strategy: " + prcStrategy + ", Max Quantity: " + maxQuantity + ", Min Quantity: " + minQuantity + ", Rest Quantity: " + restQuantity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  public void getProductNames() {
	        try {
	            String selectProductNamesQuery = "SELECT product_name FROM products";
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery(selectProductNamesQuery);

	            while (resultSet.next()) {
	                String productName = resultSet.getString("product_name");
	                System.out.println("Product Name: " + productName);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void deleteProduct(int productId) {
		    try {
		        String deleteProductQuery = "DELETE FROM products WHERE product_id = ?";
		        PreparedStatement pstmt = conn.prepareStatement(deleteProductQuery);
		        pstmt.setInt(1, productId);

		        int rowsAffected = pstmt.executeUpdate();

		        if (rowsAffected > 0) {
		            System.out.println("Product with ID " + productId + " deleted successfully.");
		        } else {
		            System.out.println("Product with ID " + productId + " not found.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	  
	  
	public static void main(String[] args) {
		DB db = DB.getDb();

//		// Add admin
//		db.addAdmin("admin123", "adminUser", "adminPass");
//
//		// Retrieve admins
//		db.getAdmins();

		
		// Retrieve products
		db.getProduct();
	}
}