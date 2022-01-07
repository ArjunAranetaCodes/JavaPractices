public class Main {
    public static void main(String[] args) {
        String sourceString = "Programming is fun";
        char[] targetArray = new char[6];

        // Using getChars to copy characters from sourceString to targetArray
        sourceString.getChars(13, 19, targetArray, 0);

        // Displaying the content of targetArray
        System.out.println(targetArray);
    }
}
