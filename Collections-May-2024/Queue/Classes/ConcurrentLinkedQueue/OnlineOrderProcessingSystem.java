import java.util.concurrent.ConcurrentLinkedQueue;

public class OnlineOrderProcessingSystem {
    private ConcurrentLinkedQueue<String> orderQueue = new ConcurrentLinkedQueue<>();

    public void addOrder(String order, String customer) {
        orderQueue.add(order);
        System.out.println(order + " added by " + customer);
    }

    public void removeOrder(String order, String customer) {
        if (orderQueue.remove(order)) {
            System.out.println(order + " removed by " + customer);
        } else {
            System.out.println(order + " not found");
        }
    }

    public static void main(String[] args) {
        OnlineOrderProcessingSystem onlineOrderProcessingSystem = new OnlineOrderProcessingSystem();

        // Customer 1
        onlineOrderProcessingSystem.addOrder("Order 1", "Customer 1");

        // Customer 2
        onlineOrderProcessingSystem.addOrder("Order 2", "Customer 2");

        // Customer 3
        onlineOrderProcessingSystem.removeOrder("Order 1", "Customer 3");

        // Customer 4
        onlineOrderProcessingSystem.addOrder("Order 3", "Customer 4");
    }
}