class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton instance created.");
    }
}
   