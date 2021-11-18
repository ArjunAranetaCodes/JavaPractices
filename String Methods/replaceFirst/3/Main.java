public class Main {
    public static void main(String[] args) {
        String originalString = "Java is cool";
        String replacedString = originalString.replaceFirst("(?i)java", "Python");
        System.out.println("Original: " + originalString);
        System.out.println("Replaced: " + replacedString);
    }
}
 