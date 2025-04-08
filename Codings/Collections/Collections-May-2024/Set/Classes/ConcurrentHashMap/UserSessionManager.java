import java.util.concurrent.ConcurrentHashMap;

public class UserSessionManager {
    private ConcurrentHashMap<String, Boolean> sessions = new ConcurrentHashMap<>();

    public void login(String user) {
        sessions.put(user, true);
    }

    public void logout(String user) {
        sessions.remove(user);
    }

    public void printSessions() {
        System.out.println(sessions.keySet());
    }

    public static void main(String[] args) {
        UserSessionManager manager = new UserSessionManager();

        Thread thread1 = new Thread(() -> {
            manager.login("User1");
        });

        Thread thread2 = new Thread(() -> {
            manager.login("User2");
        });

        Thread thread3 = new Thread(() -> {
            manager.logout("User1");
        });

        Thread thread4 = new Thread(() -> {
            manager.printSessions();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}