import java.io.FileReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("sample.txt")) {
            char[] buffer = new char[10];
            reader.read(buffer);
            System.out.println("Data read: " + new String(buffer));
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
