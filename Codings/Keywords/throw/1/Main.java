public class Main {
    public static void main(String[] args) {
        try {
            throw new Exception("This is a sample exception");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
