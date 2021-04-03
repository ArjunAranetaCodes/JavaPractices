public class Main {
    public static void main(String[] args) {
        for (int degrees = 0; degrees <= 180; degrees += 30) {
            double radians = Math.toRadians(degrees);
            System.out.println(degrees + " degrees is equal to " + radians + " radians.");
        }
    }
}
  