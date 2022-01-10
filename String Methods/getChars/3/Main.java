public class Main {
    public static void main(String[] args) {
        String sourceString = "OpenAI GPT-3.5";
        char[] targetArray = new char[8];

        // Using getChars to copy characters from sourceString to targetArray
        sourceString.getChars(7, 15, targetArray, 0);

        // Displaying the content of targetArray
        System.out.println(targetArray);
    }
}
 