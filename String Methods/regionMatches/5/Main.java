public class Main {
    public static void main(String[] args) {
        String str1 = "Java is versatile";
        String str2 = "Java";

        boolean result = str1.regionMatches(false, 0, str2, 0, 4);

        System.out.println("Do the regions (case-insensitive) match? " + result);
    }
}
