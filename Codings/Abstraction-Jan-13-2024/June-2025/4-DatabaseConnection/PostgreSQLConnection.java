package DatabaseConnection;

public class PostgreSQLConnection extends DatabaseConnection {
    private String schema;
    private boolean useConnectionPool;
    private int poolSize;
    
    public PostgreSQLConnection(String host, int port, String databaseName, 
                               String username, String password, int connectionTimeout,
                               String schema, boolean useConnectionPool, int poolSize) {
        super(host, port, databaseName, username, password, connectionTimeout);
        this.schema = schema;
        this.useConnectionPool = useConnectionPool;
        this.poolSize = poolSize;
    }
    
    @Override
    public boolean connect() {
        if (!validateConnectionParams()) {
            System.out.println("PostgreSQL: Invalid connection parameters");
            return false;
        }
        
        // Simulate PostgreSQL connection logic
        System.out.println("PostgreSQL: Connecting to " + host + ":" + port + "/" + databaseName);
        System.out.println("PostgreSQL: Using schema: " + schema + ", Connection Pool: " + useConnectionPool);
        
        // Simulate connection delay
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        setConnected(true);
        System.out.println("PostgreSQL: Connection established successfully");
        return true;
    }
    
    @Override
    public boolean disconnect() {
        if (!isConnected) {
            System.out.println("PostgreSQL: Not connected");
            return false;
        }
        
        System.out.println("PostgreSQL: Disconnecting from database");
        setConnected(false);
        System.out.println("PostgreSQL: Disconnected successfully");
        return true;
    }
    
    @Override
    public boolean executeQuery(String query) {
        if (!isConnected) {
            System.out.println("PostgreSQL: Cannot execute query - not connected");
            return false;
        }
        
        System.out.println("PostgreSQL: Executing query: " + query);
        System.out.println("PostgreSQL: Query executed successfully");
        return true;
    }
    
    @Override
    public boolean executeUpdate(String update) {
        if (!isConnected) {
            System.out.println("PostgreSQL: Cannot execute update - not connected");
            return false;
        }
        
        System.out.println("PostgreSQL: Executing update: " + update);
        System.out.println("PostgreSQL: Update executed successfully");
        return true;
    }
    
    @Override
    public String getConnectionInfo() {
        return "PostgreSQL Connection - " + host + ":" + port + "/" + databaseName + 
               " (Schema: " + schema + ", Pool: " + useConnectionPool + ")";
    }
    
    @Override
    public boolean testConnection() {
        if (!isConnected) {
            return false;
        }
        
        System.out.println("PostgreSQL: Testing connection with SELECT 1");
        System.out.println("PostgreSQL: Connection test successful");
        return true;
    }
    
    // PostgreSQL-specific methods
    public void setSchema(String schema) {
        this.schema = schema;
    }
    
    public void setUseConnectionPool(boolean useConnectionPool) {
        this.useConnectionPool = useConnectionPool;
    }
    
    public String getSchema() {
        return schema;
    }
    
    public boolean isUseConnectionPool() {
        return useConnectionPool;
    }
    
    public int getPoolSize() {
        return poolSize;
    }
    
    @Override
    public void displayConnectionStatus() {
        super.displayConnectionStatus();
        System.out.println("Schema: " + schema);
        System.out.println("Connection Pool: " + useConnectionPool);
        System.out.println("Pool Size: " + poolSize);
    }
} 