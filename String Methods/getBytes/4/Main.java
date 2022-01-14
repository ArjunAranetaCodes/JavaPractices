import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        
        byte[] byteArray = inputString.getBytes();
        
        System.out.println("Original String: " + inputString);
        System.out.print("Byte Array: ");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
        
        scanner.close();
    }
}
   