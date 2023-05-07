class Chopstick {
    private boolean taken = false;

    public synchronized void take() {
        while (taken) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        taken = true;
    }

    public synchronized void release() {
        taken = false;
        notify();
    }
}

class Philosopher extends Thread {
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;

    public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {
        super(name);
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            think();
            eat();
        }
    }

    private void think() {
        System.out.println(getName() + " is thinking.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        leftChopstick.take();
        rightChopstick.take();

        System.out.println(getName() + " is eating.");

        leftChopstick.release();
        rightChopstick.release();
    }
}

public class Main {
    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[5];
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher("Philosopher " + (i + 1), chopsticks[i], chopsticks[(i + 1) % 5]);
            philosophers[i].start();
        }
    }
}
