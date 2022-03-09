public class Main {
    public static void main(String[] args) {
        String original = "Java is amazing! 💻";
        String modified = original.substring(0, 10); // Truncate the string
        int codePointsCount = modified.codePointCount(0, modified.length());

        System.out.println("Code points count in modified string: " + codePointsCount);
    }
}
   