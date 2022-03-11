public class Main {
    public static void main(String[] args) {
        String str = "Java Programming 🚀";
        int start = 5;
        int end = 17;
        int codePointsCount = str.codePointCount(start, end);

        System.out.println("Number of Unicode code points in substring: " + codePointsCount);
    }
}
