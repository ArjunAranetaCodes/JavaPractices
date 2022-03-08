public class Main {
    public static void main(String[] args) {
        String unicodeText = "😃 Unicode Characters 😍";
        int codePointsCount = unicodeText.codePointCount(0, unicodeText.length());

        System.out.println("Code points count in Unicode text: " + codePointsCount);
    }
}
  