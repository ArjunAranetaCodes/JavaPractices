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