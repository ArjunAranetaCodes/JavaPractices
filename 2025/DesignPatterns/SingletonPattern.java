/**
 * Tutorial: Singleton Design Pattern
 * Demonstrates singleton pattern implementation
 */
class Singleton {
    private static Singleton instance;
    
    // Private constructor
    private Singleton() {
        System.out.println("Singleton instance created");
    }
    
    // Lazy initialization
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("Singleton is doing something");
    }
}

// Thread-safe singleton
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {
        System.out.println("Thread-safe singleton created");
    }
    
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

// Eager initialization
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {
        System.out.println("Eager singleton created");
    }
    
    public static EagerSingleton getInstance() {
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same instance? " + (s1 == s2));
        
        ThreadSafeSingleton ts1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton ts2 = ThreadSafeSingleton.getInstance();
        System.out.println("Same instance? " + (ts1 == ts2));
        
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();
        System.out.println("Same instance? " + (e1 == e2));
    }
}










