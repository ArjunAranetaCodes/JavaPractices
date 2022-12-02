public class Main {
    public static void main(String[] args) {
        boolean sunny = true;
        boolean warm = false;

        boolean goToBeach = sunny && warm;
        boolean stayHome = !goToBeach;

        System.out.println("Go to the beach? " + goToBeach);
    }
}
