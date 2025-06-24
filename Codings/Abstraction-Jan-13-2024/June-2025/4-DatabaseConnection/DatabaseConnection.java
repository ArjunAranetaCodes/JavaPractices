package DatabaseConnection;

// Abstract class representing a database connection
public abstract class DatabaseConnection {
    protected String host;
    protected int port;
    protected String databaseName;
    protected String username;
    protected String password;
    protected boolean isConnected;
    protected int connectionTimeout;
    
    // Constructor
    public DatabaseConnection(String host, int port, String databaseName, 
                            String username, String password, int connectionTimeout) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.connectionTimeout = connectionTimeout;
        this.isConnected = false;
    }
    
    // Abstract method - each database must implement its own connection logic
    public abstract boolean connect();
    
    // Abstract method for disconnection
    public abstract boolean disconnect();
    
    // Abstract method for executing queries
    public abstract boolean executeQuery(String query);
    
    // Abstract method for executing updates
    public abstract boolean executeUpdate(String update);
    
    // Abstract method for getting connection info
    public abstract String getConnectionInfo();
    
    // Abstract method for testing connection
    public abstract boolean testConnection();
    
    // Concrete method - shared behavior
    public void displayConnectionStatus() {
        System.out.println("Database: " + databaseName);
        System.out.println("Host: " + host + ":" + port);
        System.out.println("Username: " + username);
        System.out.println("Connected: " + isConnected);
        System.out.println("Timeout: " + connectionTimeout + "ms");
        System.out.println("------------------------");
    }
    
    // Concrete method to check if connected
    public boolean isConnected() {
        return isConnected;
    }
    
    // Concrete method to set connection status
    protected void setConnected(boolean connected) {
        this.isConnected = connected;
    }
    
    // Concrete method to validate connection parameters
    protected boolean validateConnectionParams() {
        return host != null && !host.isEmpty() && 
               port > 0 && port <= 65535 &&
               databaseName != null && !databaseName.isEmpty() &&
               username != null && !username.isEmpty() &&
               password != null && !password.isEmpty() &&
               connectionTimeout > 0;
    }
    
    // Getter methods
    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }
    
    public String getDatabaseName() {
        return databaseName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getConnectionTimeout() {
        return connectionTimeout;
    }
} 