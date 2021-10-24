public class Main {
    public static void main(String[] args) {
        String firstString = "Hello";
        String secondString = "Hello, World";

        if (secondString.startsWith(firstString)) {
            System.out.println("The second string starts with the first string.");
        } else {
            System.out.println("The second string does not start with the first string.");
        }
    }
}
