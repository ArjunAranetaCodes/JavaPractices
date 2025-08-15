public class RecordPatternUnnamed {
    record Point(int x, int y) {}

    public static void main(String[] args) {
        Point p = new Point(10, 20);

        // Only care about the x coordinate
        if (p instanceof Point(int x, _)) {
            System.out.println("x = " + x);
        }
    }
} 