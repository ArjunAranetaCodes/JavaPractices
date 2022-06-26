public class Main {
    protected Main() {
        System.out.println("Protected constructor called.");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
    }
}

