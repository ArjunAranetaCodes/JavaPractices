public class Main {
    public static void main(String[] args) {
        double temperature = -5.0;
        String weather = (Math.signum(temperature) > 0) ? "Warm" : "Cold";

        System.out.println("Temperature: " + temperature);
        System.out.println("Weather: " + weather);
    }
}
 