public class Main {
    public static void main(String[] args) {
        int number = 12345;
        byte[] byteArray = Integer.toString(number).getBytes();
        
        System.out.println("Original Integer: " + number);
        System.out.print("Byte Array: ");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
    }
}
   