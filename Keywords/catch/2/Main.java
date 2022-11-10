public class Main {
    public static void main(String[] args) {
        try {
            String str = null;
            int length = str.length(); // NullPointerException will be thrown
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}
