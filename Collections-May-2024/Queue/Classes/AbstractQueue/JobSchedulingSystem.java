import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class JobSchedulingSystem {
    private AbstractQueue<String> jobQueue = new AbstractQueue<String>() {
        private ArrayList<String> list = new ArrayList<>();

        @Override
        public Iterator<String> iterator() {
            return list.iterator();
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean offer(String e) {
            return list.add(e);
        }

        @Override
        public String peek() {
            return list.get(0);
        }

        @Override
        public String poll() {
            return list.remove(0);
        }

        @Override
        public boolean remove(Object o) {
            return list.remove(o);
        }
    };

    public void addJob(String job) {
        jobQueue.add(job);
        System.out.println("Job added: " + job);
    }

    public void processJobs() {
        while (!jobQueue.isEmpty()) {
            String job = jobQueue.poll();
            System.out.println("Processing job: " + job);
            // Simulate job processing
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Job completed: " + job);
        }
    }

    public static void main(String[] args) {
        JobSchedulingSystem jobSchedulingSystem = new JobSchedulingSystem();

        jobSchedulingSystem.addJob("Print Document");
        jobSchedulingSystem.addJob("Scan Document");
        jobSchedulingSystem.addJob("Fax Document");

        jobSchedulingSystem.processJobs();
    }
}