public class Main {
    public static void main(String[] args) {
        String str1 = "Programming is fun";
        String str2 = "Fun";

        boolean result = str1.regionMatches(14, str2, 0, 3);

        System.out.println("Do the regions match? " + result);
    }
}
 