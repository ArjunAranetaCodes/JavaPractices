public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            int element = arr[5]; // ArrayIndexOutOfBoundsException will be thrown
            String str = null;
            int length = str.length(); // NullPointerException will be thrown
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}
