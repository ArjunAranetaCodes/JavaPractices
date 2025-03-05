import java.util.concurrent.ConcurrentLinkedDeque;

public class TaskExecutor {
    private ConcurrentLinkedDeque<String> taskQueue = new ConcurrentLinkedDeque<>();

    public void addTask(String task) {
        taskQueue.add(task);
        System.out.println(task + " added to queue");
    }

    public void executeTasks() {
        while (true) {
            String task = taskQueue.poll();
            if (task != null) {
                System.out.println("Executing task: " + task);
                // Execute the task
            }
        }
    }

    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();

        Thread executor1 = new Thread(() -> {
            taskExecutor.addTask("Task 1");
        });

        Thread executor2 = new Thread(() -> {
            taskExecutor.addTask("Task 2");
        });

        Thread executor3 = new Thread(() -> {
            taskExecutor.addTask("Task 3");
        });

        Thread executor4 = new Thread(() -> {
            taskExecutor.addTask("Task 4");
        });

        executor1.start();
        executor2.start();
        executor3.start();
        executor4.start();

        taskExecutor.executeTasks();
    }
}