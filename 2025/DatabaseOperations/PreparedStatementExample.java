/**
 * Tutorial: Database Operations - PreparedStatement
 * Demonstrates using PreparedStatement for database operations
 */
import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        
        try {
            // Load driver and connect
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Create table (if not exists)
            String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100))";
            
            Statement stmt = connection.createStatement();
            stmt.execute(createTable);
            System.out.println("Table created/verified");
            
            // Insert using PreparedStatement
            String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertSQL);
            
            pstmt.setString(1, "Alice");
            pstmt.setString(2, "alice@example.com");
            pstmt.executeUpdate();
            System.out.println("Inserted: Alice");
            
            pstmt.setString(1, "Bob");
            pstmt.setString(2, "bob@example.com");
            pstmt.executeUpdate();
            System.out.println("Inserted: Bob");
            
            // Select using PreparedStatement
            String selectSQL = "SELECT * FROM users WHERE name = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
            selectStmt.setString(1, "Alice");
            
            ResultSet rs = selectStmt.executeQuery();
            System.out.println("\nQuery Results:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                    ", Name: " + rs.getString("name") + 
                    ", Email: " + rs.getString("email"));
            }
            
            // Update using PreparedStatement
            String updateSQL = "UPDATE users SET email = ? WHERE name = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateSQL);
            updateStmt.setString(1, "alice.new@example.com");
            updateStmt.setString(2, "Alice");
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println("\nRows updated: " + rowsUpdated);
            
            // Close resources
            rs.close();
            selectStmt.close();
            updateStmt.close();
            pstmt.close();
            stmt.close();
            connection.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}

