public class Main {
    public static void main(String[] args) {
        String originalString = "Price: $20.50";
        String replacedString = originalString.replaceFirst("\\$\\d+", "$50.00");
        System.out.println("Original: " + originalString);
        System.out.println("Replaced: " + replacedString);
    }
}
   