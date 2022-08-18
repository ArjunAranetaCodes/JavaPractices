import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("sample.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
        }
    }
}
