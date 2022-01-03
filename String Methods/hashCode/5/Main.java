import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Using Objects.hash() to calculate hashCode for multiple values
        int hashCode = Objects.hash(10, "Sample", true);
        System.out.println("Combined HashCode: " + hashCode);
    }
}
