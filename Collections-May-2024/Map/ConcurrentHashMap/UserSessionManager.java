import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Map;

public class UserSessionManager {
    private ConcurrentMap<String, String> sessions;

    public UserSessionManager() {
        this.sessions = new ConcurrentHashMap<>();
    }

    public void createUserSession(String user, String session) {
        sessions.put(user, session);
    }

    public String getUserSession(String user) {
        return sessions.get(user);
    }

    public int getActiveUserCount() {
        return sessions.size();
    }

    public static void main(String[] args) {
        UserSessionManager manager = new UserSessionManager();

        manager.createUserSession("user1", "session1");
        manager.createUserSession("user2", "session2");
        manager.createUserSession("user3", "session3");

        System.out.println("User sessions:");
        for (Map.Entry<String, String> entry : manager.sessions.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Active user count: " + manager.getActiveUserCount());
    }
}