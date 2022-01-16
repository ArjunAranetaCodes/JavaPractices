import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        String inputString = "Java Programming";
        try {
            byte[] byteArray = inputString.getBytes("UTF-8");
            
            System.out.println("Original String: " + inputString);
            System.out.print("Byte Array (UTF-8): ");
            for (byte b : byteArray) {
                System.out.print(b + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
