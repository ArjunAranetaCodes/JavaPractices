public class Main {
    public static void main(String[] args) {
        String originalString = "apple orange apple orange";
        String replacedString = originalString.replaceFirst("apple", "banana");
        System.out.println("Original: " + originalString);
        System.out.println("Replaced: " + replacedString);
    }

}
 