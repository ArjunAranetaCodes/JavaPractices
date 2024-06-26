## Problem: 
Implementing a User Preferences Manager

## Description: 
Create a program that demonstrates the use of Properties to manage user preferences.

## Input:

User preferences (user.props):

font.size=12

font.style=bold

background.color=white

## Output:

User preferences:

Font Size: 12

Font Style: bold

Background Color: white

## Code Answer:
```Java
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserPreferencesManager {
    private Properties props;

    public UserPreferencesManager() {
        props = new Properties();
    }

    public void loadPreferences() {
        try {
            props.load(new FileInputStream("user.props"));
        } catch (IOException e) {
            System.err.println("Error loading user preferences");
        }
    }

    public void savePreferences() {
        try {
            props.store(new FileOutputStream("user.props"), null);
        } catch (IOException e) {
            System.err.println("Error saving user preferences");
        }
    }

    public String getPreference(String key) {
        return props.getProperty(key);
    }

    public void setPreference(String key, String value) {
        props.setProperty(key, value);
    }

    public static void main(String[] args) {
        UserPreferencesManager manager = new UserPreferencesManager();

        manager.loadPreferences();

        System.out.println("User preferences:");
        System.out.println("Font Size: " + manager.getPreference("font.size"));
        System.out.println("Font Style: " + manager.getPreference("font.style"));
        System.out.println("Background Color: " + manager.getPreference("background.color"));

        manager.setPreference("font.size", "14");
        manager.savePreferences();
    }
}
```

File Name: UserPreferencesManager.java

This program demonstrates the use of Properties to manage user preferences. The UserPreferencesManager class uses a Properties object to load and store user preferences, and provides methods for retrieving and setting preferences.

Note: Properties is used to manage user preferences. This is useful for creating user preference files, settings files, and other similar data structures that need to be stored and retrieved.