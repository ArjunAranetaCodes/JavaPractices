public class Main {
    public static void main(String[] args) {
        double side1 = 8.0;
        double side2 = 15.0;
        double hypotenuse = Math.hypot(side1, side2);

        System.out.println("Hypotenuse of the right-angled triangle: " + hypotenuse);
    }
}
