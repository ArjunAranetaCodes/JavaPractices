public class Main {
    public static void main(String[] args) {
        String sourceString = "Java Programming";
        char[] targetArray = new char[10];

        // Using getChars to copy characters from sourceString to targetArray
        sourceString.getChars(5, 15, targetArray, 0);

        // Displaying the content of targetArray
        System.out.println(targetArray);
    }
}
 