public class Main {
    public static void main(String[] args) {
        String originalString = "Java is a powerful programming language.";
        String oldSubstring = "powerful";
        String newSubstring = "awesome";

        String modifiedString = originalString.replace(oldSubstring, newSubstring);

        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
    }
}
