public class Main {
    public static void main(String[] args) {
        String sourceString = "Java Examples";
        char[] targetArray = new char[7];

        // Using getChars to copy characters from sourceString to targetArray
        sourceString.getChars(5, 12, targetArray, 0);

        // Displaying the content of targetArray
        System.out.println(targetArray);
    }
}
