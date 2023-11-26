public class DaemonThreadLambda {
    public static void main(String[] args) {
        // Lambda expression for daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
            }
        });

        // Set the thread as daemon
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        System.out.println("Main thread finished.");
    }
}
