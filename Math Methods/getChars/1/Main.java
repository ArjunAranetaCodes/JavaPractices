public class Main {
    public static void main(String[] args) {
        String sourceString = "Hello, World!";
        char[] targetArray = new char[12];

        // Using getChars to copy characters from sourceString to targetArray
        sourceString.getChars(0, 12, targetArray, 0);

        // Displaying the content of targetArray
        System.out.println(targetArray);
    }
}
  