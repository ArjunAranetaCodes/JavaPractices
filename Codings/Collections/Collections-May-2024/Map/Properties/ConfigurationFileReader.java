import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigurationFileReader {
    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.err.println("Error loading configuration file");
        }

        System.out.println("Configuration settings:");
        System.out.println("Database URL: " + props.getProperty("database.url"));
        System.out.println("Database Username: " + props.getProperty("database.username"));
        System.out.println("Database Password: " + props.getProperty("database.password"));
    }
}