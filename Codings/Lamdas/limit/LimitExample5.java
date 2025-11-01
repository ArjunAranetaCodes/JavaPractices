import java.io.File;
import java.util.Arrays;

public class LimitExample5 {
    public static void main(String[] args) {
        // Listing and limiting files in the current directory
        Arrays.stream(new File(".").listFiles())
                .limit(3)
                .forEach(file -> System.out.println(file.getName()));
    }
}
