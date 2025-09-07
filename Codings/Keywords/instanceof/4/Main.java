public class Main {
    public static void main(String[] args) {
        String text = null;

        if (text instanceof String) {
            System.out.println("The text is a String");
        } else {
            System.out.println("The text is null");
        }
    }
}
