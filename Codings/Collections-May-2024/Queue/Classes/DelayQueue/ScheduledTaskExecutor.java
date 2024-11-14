import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskExecutor {
    private DelayQueue<DelayedTask> taskQueue = new DelayQueue<>();

    public void addTask(DelayedTask task) {
        taskQueue.add(task);
    }

    public void executeTasks() {
        while (true) {
            try{
                DelayedTask task = taskQueue.take();
                System.out.println("Task executed: " + task.getTaskName());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            // Execute the task
        }
    }

    public static void main(String[] args) {
        ScheduledTaskExecutor scheduledTaskExecutor = new ScheduledTaskExecutor();

        DelayedTask task1 = new DelayedTask("Task 1", 5, TimeUnit.SECONDS);
        DelayedTask task2 = new DelayedTask("Task 2", 10, TimeUnit.SECONDS);
        DelayedTask task3 = new DelayedTask("Task 3", 15, TimeUnit.SECONDS);

        scheduledTaskExecutor.addTask(task1);
        scheduledTaskExecutor.addTask(task2);
        scheduledTaskExecutor.addTask(task3);

        scheduledTaskExecutor.executeTasks();
    }
}

class DelayedTask implements Delayed {
    private String taskName;
    private long delay;
    private TimeUnit timeUnit;

    public DelayedTask(String taskName, long delay, TimeUnit timeUnit) {
        this.taskName = taskName;
        this.delay = delay;
        this.timeUnit = timeUnit;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return timeUnit.convert(delay, unit);
    }

    @Override
    public int compareTo(Delayed o) {
        return 1;
    }
}