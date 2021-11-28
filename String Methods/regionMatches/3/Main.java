public class Main {
    public static void main(String[] args) {
        String str1 = "OpenAI is amazing!";
        String str2 = "OpenAI";

        boolean result = str1.regionMatches(0, str2, 0, 6);

        System.out.println("Do the regions match? " + result);
    }
}
