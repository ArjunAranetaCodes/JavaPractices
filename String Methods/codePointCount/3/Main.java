public class Main {
    public static void main(String[] args) {
        String text = "CodePointCount Example";
        int start = 6;
        int end = 16;
        int codePointsCount = text.codePointCount(start, end);

        System.out.println("Code points count in range: " + codePointsCount);
    }
}
 