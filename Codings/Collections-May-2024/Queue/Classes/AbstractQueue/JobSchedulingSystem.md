## Problem: 
Job Scheduling System

## Description: 
Create a program that demonstrates the methods of the AbstractQueue class in a real-world implementation. The program should simulate a job scheduling system where jobs are added to a queue and processed in the order they are received.

## Input:
Job 1: Print Document
Job 2: Scan Document
Job 3: Fax Document
## Output:
Job 1: Print Document (Processing)
Job 2: Scan Document (Processing)
Job 3: Fax Document (Processing)
Job 1: Print Document (Completed)
Job 2: Scan Document (Completed)
Job 3: Fax Document (Completed)
## Code Answer:
```Java
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
```
File Name: JobSchedulingSystem.java

This program demonstrates the methods of the AbstractQueue class in a real-world implementation of a job scheduling system. Jobs are added to the queue using the addJob method, and processed in the order they are received using the processJobs method. The program simulates job processing by sleeping for 1 second between each job. The output shows the jobs being added, processed, and completed.