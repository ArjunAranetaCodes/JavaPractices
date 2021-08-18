import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        
        double cubeRoot = Math.cbrt(num);
        
        System.out.println("Cube root of " + num + " is: " + cubeRoot);
    }
}
  