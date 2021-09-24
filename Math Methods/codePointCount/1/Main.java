public class Main {
    public static void main(String[] args) {
        String str = "Hello, World! 👋";
        int start = 0;
        int end = str.length();
        int codePointsCount = str.codePointCount(start, end);

        System.out.println("Number of Unicode code points: " + codePointsCount);
    }
}
    