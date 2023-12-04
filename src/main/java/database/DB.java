package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

            String url = "jdbc:sqlite:warehouse.db";  // SQLite connection string
            // connection
            conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();

            String create_adminTable = "CREATE TABLE IF NOT EXISTS admins_info ("
                    + "admin_id TEXT NOT NULL UNIQUE, "
                    + "username TEXT, "
                    + "password TEXT, "
                    + "PRIMARY KEY (username, password)"
                    + ");";

            String create_productTable = "CREATE TABLE IF NOT EXISTS products ("
                    + "product_id INTEGER PRIMARY KEY, "
                    + "product_name TEXT, "
                    + "price REAL, "
                    + "quantity INTEGER, "
                    + "PRCStrategy TEXT, "
                    + "MaxQuantity INTEGER, "
                    + "MinQuantity INTEGER, "
                    + "RestQuantity INTEGER"
                    + ");";

            statement.executeUpdate(create_adminTable);
            statement.executeUpdate(create_productTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




			public static void addProduct(int productId, String productName, int price, double quantity) {
				try {
					// Establishing a connection
//					Connection connection = DriverManager.getConnection(url, user, password);

					// SQL statement for inserting a new product
					String insertProductSQL = "INSERT INTO products (product_id, product_name, price, quantity) VALUES (?, ?, ?, ?)";

					// Creating a prepared statement
					PreparedStatement preparedStatement = conn.prepareStatement(insertProductSQL);

					// Setting parameters for the new product
					preparedStatement.setInt(1, productId);
					preparedStatement.setString(2, productName);
					preparedStatement.setInt(3, price);
					preparedStatement.setDouble(4, quantity);

					// Executing the SQL statement
					preparedStatement.executeUpdate();

					// Closing resources
					preparedStatement.close();
					conn.close();

					System.out.println("Product added successfully!");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			

			}
			 public static void deleteProduct(int productId) {
			        try {
			           		            // SQL statement for deleting a product
			            String deleteProductSQL = "DELETE FROM products WHERE product_id = ?";

			            // Creating a prepared statement
			            PreparedStatement preparedStatement = conn.prepareStatement(deleteProductSQL);

			            // Setting parameter for the product to be deleted
			            preparedStatement.setInt(1, productId);

			            // Executing the SQL statement
			            int rowsAffected = preparedStatement.executeUpdate();

			            // Closing resources
			            preparedStatement.close();
			            conn.close();

			            if (rowsAffected > 0) {
			                System.out.println("Product deleted successfully!");
			            } else {
			                System.out.println("Product not found or not deleted.");
			            }

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }

			 public static double getMaxQuantity(int productId) {
			        double maxQuantity = 0;

			        try {
			           

			            // SQL statement for finding the max quantity for a product
			            String maxQuantitySQL = "SELECT MAX(quantity) FROM products WHERE product_id = ?";

			            // Creating a prepared statement
			            PreparedStatement preparedStatement = conn.prepareStatement(maxQuantitySQL);

			            // Setting parameter for the product
			            preparedStatement.setInt(1, productId);

			            // Executing the SQL statement
			            ResultSet resultSet = preparedStatement.executeQuery();

			            // Retrieving the max quantity
			            if (resultSet.next()) {
			                maxQuantity = resultSet.getDouble(1);
			            }

			            // Closing resources
			            resultSet.close();
			            preparedStatement.close();
			            conn.close();

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }

			        return maxQuantity;
			    }
			 
			 public static void decreaseQuantity(String productId, double quantityToDecrease) {
			     try (
			            
			             PreparedStatement preparedStatement = conn.prepareStatement("UPDATE products SET quantity = quantity - ? WHERE product_id = ?")
			         ) {
			             // Setting parameters for the update
			             preparedStatement.setDouble(1, quantityToDecrease);
			             preparedStatement.setString(2, productId);

			             // Executing the SQL statement
			             preparedStatement.executeUpdate();

			         } catch (SQLException e) {
			             e.printStackTrace();
			         }
			     }
			    
		}

