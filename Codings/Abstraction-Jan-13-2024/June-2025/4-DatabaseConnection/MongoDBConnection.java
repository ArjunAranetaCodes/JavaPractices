package DatabaseConnection;

public class MongoDBConnection extends DatabaseConnection {
    private String collection;
    private boolean useReplicaSet;
    private String replicaSetName;
    
    public MongoDBConnection(String host, int port, String databaseName, 
                            String username, String password, int connectionTimeout,
                            String collection, boolean useReplicaSet, String replicaSetName) {
        super(host, port, databaseName, username, password, connectionTimeout);
        this.collection = collection;
        this.useReplicaSet = useReplicaSet;
        this.replicaSetName = replicaSetName;
    }
    
    @Override
    public boolean connect() {
        if (!validateConnectionParams()) {
            System.out.println("MongoDB: Invalid connection parameters");
            return false;
        }
        
        // Simulate MongoDB connection logic
        System.out.println("MongoDB: Connecting to " + host + ":" + port + "/" + databaseName);
        System.out.println("MongoDB: Using collection: " + collection + ", Replica Set: " + useReplicaSet);
        
        // Simulate connection delay
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        setConnected(true);
        System.out.println("MongoDB: Connection established successfully");
        return true;
    }
    
    @Override
    public boolean disconnect() {
        if (!isConnected) {
            System.out.println("MongoDB: Not connected");
            return false;
        }
        
        System.out.println("MongoDB: Disconnecting from database");
        setConnected(false);
        System.out.println("MongoDB: Disconnected successfully");
        return true;
    }
    
    @Override
    public boolean executeQuery(String query) {
        if (!isConnected) {
            System.out.println("MongoDB: Cannot execute query - not connected");
            return false;
        }
        
        System.out.println("MongoDB: Executing query: " + query);
        System.out.println("MongoDB: Query executed successfully");
        return true;
    }
    
    @Override
    public boolean executeUpdate(String update) {
        if (!isConnected) {
            System.out.println("MongoDB: Cannot execute update - not connected");
            return false;
        }
        
        System.out.println("MongoDB: Executing update: " + update);
        System.out.println("MongoDB: Update executed successfully");
        return true;
    }
    
    @Override
    public String getConnectionInfo() {
        return "MongoDB Connection - " + host + ":" + port + "/" + databaseName + 
               " (Collection: " + collection + ", Replica Set: " + useReplicaSet + ")";
    }
    
    @Override
    public boolean testConnection() {
        if (!isConnected) {
            return false;
        }
        
        System.out.println("MongoDB: Testing connection with ping");
        System.out.println("MongoDB: Connection test successful");
        return true;
    }
    
    // MongoDB-specific methods
    public void setCollection(String collection) {
        this.collection = collection;
    }
    
    public void setUseReplicaSet(boolean useReplicaSet) {
        this.useReplicaSet = useReplicaSet;
    }
    
    public String getCollection() {
        return collection;
    }
    
    public boolean isUseReplicaSet() {
        return useReplicaSet;
    }
    
    public String getReplicaSetName() {
        return replicaSetName;
    }
    
    @Override
    public void displayConnectionStatus() {
        super.displayConnectionStatus();
        System.out.println("Collection: " + collection);
        System.out.println("Replica Set: " + useReplicaSet);
        System.out.println("Replica Set Name: " + replicaSetName);
    }
} 