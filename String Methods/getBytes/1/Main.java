public class Main {
    public static void main(String[] args) {
        String inputString = "Hello, World!";
        byte[] byteArray = inputString.getBytes();
        
        System.out.println("Original String: " + inputString);
        System.out.print("Byte Array: ");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
    }
}
