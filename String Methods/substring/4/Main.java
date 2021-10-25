public class Main {
    public static void main(String[] args) {
        String originalString = "java programming";
        int startIndex = 0;
        int endIndex = 4;
        
        String substring = originalString.substring(startIndex, endIndex);
        String uppercaseSubstring = substring.toUpperCase();

        System.out.println("Original String: " + originalString);
        System.out.println("Uppercase Substring: " + uppercaseSubstring);
    }
}
