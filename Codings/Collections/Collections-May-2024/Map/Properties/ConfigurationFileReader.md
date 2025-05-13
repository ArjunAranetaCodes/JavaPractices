## Problem: 
Implementing a Configuration File Reader

## Description: 
Create a program that demonstrates the use of Properties to read and store configuration settings from a file.

## Input:

Configuration file (config.properties):

database.url=jdbc:mysql://localhost:3306/mydb

database.username=myuser

database.password=mypassword

## Output:

Configuration settings:

Database URL: jdbc:mysql://localhost:3306/mydb

Database Username: myuser

Database Password:mypassword

## Code Answer:
```Java
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
```

File Name: ConfigurationFileReader.java

This program demonstrates the use of Properties to read and store configuration settings from a file. The ConfigurationFileReader class uses a Properties object to load the configuration file, and then retrieves and prints the configuration settings.

Note: Properties is used to read and store configuration settings from a file. This is useful for creating configuration files, settings files, and other similar data structures that need to be stored and retrieved.