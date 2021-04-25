public class Main {
    public static void main(String[] args) {
        double x1 = 1.0, y1 = 2.0;
        double x2 = 4.0, y2 = 6.0;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Distance between points (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is: " + distance);
    }
}
   