import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputString = "Writing to File";
        byte[] byteArray = inputString.getBytes();
        
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            fos.write(byteArray);
            System.out.println("Byte Array written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
