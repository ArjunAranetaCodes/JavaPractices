## Java Multithreading Tutorial

Multithreading in Java allows concurrent execution of two or more threads for maximum utilization of CPU. Below, we will explore various methods related to multithreading with examples.

### 1. `start()` Method

The `start()` method is used to begin the execution of a thread. The Java Virtual Machine (JVM) calls the `run()` method of the thread.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Start the thread
    }
}
```

### 2. `suspend()` Method

The `suspend()` method is deprecated and should not be used because it is inherently deadlock-prone. However, for educational purposes, here's how it was used:

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        t1.suspend(); // Suspend the thread (deprecated)
        t1.resume();  // Resume the thread (deprecated)
    }
}
```

### 3. `stop()` Method

The `stop()` method is also deprecated due to its unsafe nature. It can leave shared resources in an inconsistent state.

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        t1.stop(); // Stop the thread (deprecated)
    }
}
```

### 4. `wait()` Method

The `wait()` method causes the current thread to wait until another thread invokes the `notify()` or `notifyAll()` method for this object.

```java
class MyThread {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 waiting...");
                    lock.wait();
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 notifying...");
                lock.notify();
            }
        });

        t1.start();
        try {
            Thread.sleep(1000); // Ensure t1 starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
```

### 5. `notify()` Method

The `notify()` method wakes up a single thread that is waiting on this object's monitor.

```java
// Refer to the example in the `wait()` method section.
```

### 6. `notifyAll()` Method

The `notifyAll()` method wakes up all threads that are waiting on this object's monitor.

```java
class MyThread {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 waiting...");
                    lock.wait();
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 2 waiting...");
                    lock.wait();
                    System.out.println("Thread 2 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 3 notifying all...");
                lock.notifyAll();
            }
        });

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000); // Ensure t1 and t2 start first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }
}
```

### 7. `sleep()` Method

The `sleep()` method causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
```

### 8. Output Without `sleep()` Method

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
```

### 9. Output with `sleep()` Method in Serial Execution Processes (Blocking methods approach)

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        try {
            t1.join(); // Ensure t1 completes before main thread continues
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");
    }
}
```

### 10. Output with `sleep()` Method in Parallel Execution Processes (Unblocking methods approach)

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
```

### 11. `join()` Method

The `join()` method allows one thread to wait for the completion of another.

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        try {
            t1.join(); // Wait for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
```

This tutorial covers the essential multithreading methods in Java. Remember to avoid using deprecated methods like `suspend()` and `stop()` in production code due to their unsafe nature.