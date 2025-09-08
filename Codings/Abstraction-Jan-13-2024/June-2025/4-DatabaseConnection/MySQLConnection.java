package DatabaseConnection;

public class MySQLConnection extends DatabaseConnection {
    private String charset;
    private boolean useSSL;
    private int maxConnections;
    
    public MySQLConnection(String host, int port, String databaseName, 
                          String username, String password, int connectionTimeout,
                          String charset, boolean useSSL, int maxConnections) {
        super(host, port, databaseName, username, password, connectionTimeout);
        this.charset = charset;
        this.useSSL = useSSL;
        this.maxConnections = maxConnections;
    }
    
    @Override
    public boolean connect() {
        if (!validateConnectionParams()) {
            System.out.println("MySQL: Invalid connection parameters");
            return false;
        }
        
        // Simulate MySQL connection logic
        System.out.println("MySQL: Connecting to " + host + ":" + port + "/" + databaseName);
        System.out.println("MySQL: Using charset: " + charset + ", SSL: " + useSSL);
        
        // Simulate connection delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        setConnected(true);
        System.out.println("MySQL: Connection established successfully");
        return true;
    }
    
    @Override
    public boolean disconnect() {
        if (!isConnected) {
            System.out.println("MySQL: Not connected");
            return false;
        }
        
        System.out.println("MySQL: Disconnecting from database");
        setConnected(false);
        System.out.println("MySQL: Disconnected successfully");
        return true;
    }
    
    @Override
    public boolean executeQuery(String query) {
        if (!isConnected) {
            System.out.println("MySQL: Cannot execute query - not connected");
            return false;
        }
        
        System.out.println("MySQL: Executing query: " + query);
        System.out.println("MySQL: Query executed successfully");
        return true;
    }
    
    @Override
    public boolean executeUpdate(String update) {
        if (!isConnected) {
            System.out.println("MySQL: Cannot execute update - not connected");
            return false;
        }
        
        System.out.println("MySQL: Executing update: " + update);
        System.out.println("MySQL: Update executed successfully");
        return true;
    }
    
    @Override
    public String getConnectionInfo() {
        return "MySQL Connection - " + host + ":" + port + "/" + databaseName + 
               " (Charset: " + charset + ", SSL: " + useSSL + ")";
    }
    
    @Override
    public boolean testConnection() {
        if (!isConnected) {
            return false;
        }
        
        System.out.println("MySQL: Testing connection with ping");
        System.out.println("MySQL: Connection test successful");
        return true;
    }
    
    // MySQL-specific methods
    public void setCharset(String charset) {
        this.charset = charset;
    }
    
    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }
    
    public String getCharset() {
        return charset;
    }
    
    public boolean isUseSSL() {
        return useSSL;
    }
    
    public int getMaxConnections() {
        return maxConnections;
    }
    
    @Override
    public void displayConnectionStatus() {
        super.displayConnectionStatus();
        System.out.println("Charset: " + charset);
        System.out.println("SSL Enabled: " + useSSL);
        System.out.println("Max Connections: " + maxConnections);
    }
} 